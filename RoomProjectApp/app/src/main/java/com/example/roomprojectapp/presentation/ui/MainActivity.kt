package com.example.roomprojectapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomprojectapp.R
import com.example.roomprojectapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var btnAme : Button
    private lateinit var btnChiv : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAme = findViewById(R.id.btnAmerica)
        btnAme.setOnClickListener {
            val selectedTeam = 1
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("team", selectedTeam)
            }
            startActivity(intent)
        }

        btnChiv = findViewById(R.id.btnChivas)
        btnChiv.setOnClickListener {
            val selectedTeam = 2
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("team", selectedTeam)
            }
            startActivity(intent)
        }
    }

}
