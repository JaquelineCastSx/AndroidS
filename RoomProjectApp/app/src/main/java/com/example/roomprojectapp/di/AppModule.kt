package com.example.roomprojectapp.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomprojectapp.data.RoomDB
import com.example.roomprojectapp.data.mockData.MockData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton
import android.content.Context
import com.example.roomprojectapp.data.repositories.PlayerRepositoryImpl
import com.example.roomprojectapp.domain.repositories.PlayerRepository
import com.example.roomprojectapp.domain.use_cases.getPlayers
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Volatile
    private var INSTANCE : RoomDB? = null

    @Provides
    @Singleton
    fun provideRoomDB(
        @ApplicationContext context : Context
    ) : RoomDB{
        return INSTANCE ?: synchronized(this){
            val instance = INSTANCE
            if(instance != null){
                return instance
            }
            else{
                var callback = object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            val db = INSTANCE ?: return@launch
                            val playerDao = db.playerDao()
                            playerDao.insertPlayer(MockData.players)
                        }
                    }
                }
                return Room.databaseBuilder(context.applicationContext,
                    RoomDB::class.java,"room_DB")
                    .addCallback(callback).build().also {
                        INSTANCE = it
                    }
            }
        }
    }

    @Provides
    @Singleton
    fun providePlayerRepository(db : RoomDB) :PlayerRepository{
        return PlayerRepositoryImpl(db.playerDao())
    }

    @Provides
    @Singleton
    fun provideGetPlayers(playerRepository:PlayerRepository) : getPlayers{
        return getPlayers(playerRepository)
    }
}