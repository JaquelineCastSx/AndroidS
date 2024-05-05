package com.example.loginapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.loginapp.R
import com.example.loginapp.presentation.events.LoginEvent
import com.example.loginapp.presentation.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {
    private lateinit var logoutBtn : Button
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        logoutBtn = findViewById(R.id.logoutBtn)

        logoutBtn.setOnClickListener {
            loginViewModel.onEvent(LoginEvent.onLogout)
            val intent = Intent(this@Home,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}