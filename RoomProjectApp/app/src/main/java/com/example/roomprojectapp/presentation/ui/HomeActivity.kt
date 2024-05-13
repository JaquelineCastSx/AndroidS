package com.example.roomprojectapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomprojectapp.R
import com.example.roomprojectapp.domain.adapters.PlayersAdapter
import com.example.roomprojectapp.domain.models.Player
import com.example.roomprojectapp.presentation.states.PlayerState
import com.example.roomprojectapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView
    private lateinit var filteredPlayers: List<Player>
    private var team : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        team = intent.getIntExtra("team", -1)
        observeState()
    }

    private fun observeState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.state.collect{
                    Log.i("Products", it.players.toString())
                    filteredPlayers = it.players.filter { player -> player.team == team }
                    recyclerView = findViewById(R.id.recyclerView)
                    recyclerView.adapter = PlayersAdapter(filteredPlayers){player ->
                        val intent = Intent(this@HomeActivity, PlayerDetailActivity::class.java).apply {
                            putExtra("player", player)
                        }
                        startActivity(intent)
                    }
                    val layoutManager = GridLayoutManager(this@HomeActivity, 2)
                    recyclerView.layoutManager = layoutManager
                }
            }
        }
    }

}