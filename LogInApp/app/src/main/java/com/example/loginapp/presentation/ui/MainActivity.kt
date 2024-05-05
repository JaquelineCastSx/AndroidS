package com.example.loginapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.loginapp.R
import com.example.loginapp.data.mockdata.MockData
import com.example.loginapp.presentation.events.LoginEvent
import com.example.loginapp.presentation.viewmodels.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var logInBtn : Button
    private lateinit var emailET : EditText
    private lateinit var passwordET : EditText
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity, Home::class.java)
            startActivity(intent)
            finish()
        }
        logInBtn = findViewById(R.id.loginBtn)
        observeMessages()
        observeLoginState()
        emailET = findViewById(R.id.emailET)
        passwordET = findViewById(R.id.passwordET)
        logInBtn.setOnClickListener{
            val email = emailET.text.toString()
            val password = passwordET.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Snackbar.make(logInBtn, "Por favor llena todos los campos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            login(email,password)
        }
    }
    private fun login(email:String, password:String){
        loginViewModel.onEvent(LoginEvent.OnLogin(email, password))
    }

    private fun observeLoginState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                loginViewModel.loginState.collect{state ->
                    if(state.isLogged){
                        val intent = Intent(this@MainActivity,Home::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    private fun observeMessages(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                loginViewModel.uiChannel.collect{
                    Snackbar.make(logInBtn, it, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}