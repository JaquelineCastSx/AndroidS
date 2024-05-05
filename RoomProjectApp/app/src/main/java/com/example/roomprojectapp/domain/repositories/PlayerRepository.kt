package com.example.roomprojectapp.domain.repositories

import com.example.roomprojectapp.domain.models.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    suspend fun getPlayers() : Flow<List<Player>>
}