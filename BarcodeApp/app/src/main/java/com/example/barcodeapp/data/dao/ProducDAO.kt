package com.example.barcodeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.barcodeapp.domain.models.Product

@Dao
interface ProducDAO {
    @Query("SELECT * FROM product")
    fun getAllProducts() : List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products:List<Product>)
}