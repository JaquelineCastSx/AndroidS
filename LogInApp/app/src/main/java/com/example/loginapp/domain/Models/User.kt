package com.example.loginapp.domain.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val email:String,
    val password:String
)