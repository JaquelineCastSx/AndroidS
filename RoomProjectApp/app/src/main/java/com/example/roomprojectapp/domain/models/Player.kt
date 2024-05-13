package com.example.roomprojectapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val team : Int,
    val position : String,
    val imagen : String
):Serializable
