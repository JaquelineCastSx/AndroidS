package com.example.roomprojectapp.data.repositories

import com.example.roomprojectapp.data.dao.PlayerDao
import com.example.roomprojectapp.domain.models.Player
import com.example.roomprojectapp.domain.repositories.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerDao: PlayerDao
): PlayerRepository {
    override suspend fun getPlayers(): Flow<List<Player>> {
        return playerDao.getPlayers()
    }
}