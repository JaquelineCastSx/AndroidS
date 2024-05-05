package com.example.roomprojectapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val position : String,
    val imagen : String
)
