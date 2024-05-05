package com.example.roomprojectapp.domain.use_cases

import com.example.roomprojectapp.domain.models.Player
import com.example.roomprojectapp.domain.repositories.PlayerRepository
import kotlinx.coroutines.flow.Flow

class getPlayers(
    private val repository : PlayerRepository
) {
    suspend operator fun invoke() : Flow<List<Player>> {
        return repository.getPlayers()
    }
}