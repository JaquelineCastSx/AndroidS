package com.example.roomprojectapp.presentation.states

import com.example.roomprojectapp.domain.models.Player

data class PlayerState(
    val players : List<Player> = emptyList()
)