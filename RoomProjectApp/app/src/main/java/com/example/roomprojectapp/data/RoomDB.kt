package com.example.roomprojectapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomprojectapp.data.dao.PlayerDao
import com.example.roomprojectapp.domain.models.Player

@Database(entities = [Player::class], version = 1)
abstract class RoomDB : RoomDatabase(){
    abstract fun playerDao() : PlayerDao
}