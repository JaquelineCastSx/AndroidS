package com.example.roomprojectapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomprojectapp.domain.use_cases.getPlayers
import com.example.roomprojectapp.presentation.states.PlayerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlayers: getPlayers
) : ViewModel(){
    private val _state = MutableStateFlow(PlayerState())
    val state = _state.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launch {
            try {
                getPlayers().collect{
                    _state.value = PlayerState(players = it)
                }
            }
            catch (e : Exception){
                Log.i("ERROR","Falló el metodo get Players")
            }
        }
    }
}