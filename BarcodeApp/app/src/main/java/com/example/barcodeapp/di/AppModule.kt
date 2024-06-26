package com.example.barcodeapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.barcodeapp.data.BarcodeDB
import com.example.barcodeapp.data.dao.ProducDAO
import com.example.barcodeapp.data.repositories.ProductRepositoryImpl
import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepositorie
import com.example.barcodeapp.domain.use_cases.getProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideString() :String{
        return "Hola desde Dagger Hilt"
    }

    @Volatile
    private var INSTANCE : BarcodeDB? = null

    @Provides
    @Singleton
    fun provideBarcodeDB(
        @ApplicationContext context:Context
    ) : BarcodeDB{
        // ?: Elvis operator
    return INSTANCE ?: synchronized(this){
        val instance = INSTANCE
        if(instance != null){
            instance
        }else{
            val callback = object : RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch{
                        val db = INSTANCE ?: return@launch
                        val productDao = db.productDao()
                        populateDatabase(productDao)
                    }
                }
                suspend fun populateDatabase(productDao : ProducDAO){
                val products = Product.products
                productDao.insertAll(products)
            }
            }
            Room.databaseBuilder(context.applicationContext,
                BarcodeDB::class.java,"barcode_DB")
                .addCallback(callback).build().also {
                    INSTANCE = it
                }
        }
    }
//        val callback= object : RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
//                applicationScope.launch {
//                    val barcodeDb = provideBarcodeDB(context)
//                    val productDao = barcodeDb.productDao()
//                    populateDatabase(productDao)
//                }
//            }
//            suspend fun populateDatabase(productDao : ProducDAO){
//                val products = Product.products
//                productDao.insertAll(products)
//            }
//        }
//
//        return Room.databaseBuilder(
//            context,
//            BarcodeDB::class.java,
//            "barcode_DB"
//        ).addCallback(callback).build()
    }

    @Provides
    @Singleton
    fun provideProductRepository(db : BarcodeDB) :ProductRepositorie{
        return ProductRepositoryImpl(db.productDao())
    }

    @Provides
    @Singleton
    fun provideGetProducts(productRepository:ProductRepositorie) : getProducts{
        return getProducts(productRepository)
    }
}
