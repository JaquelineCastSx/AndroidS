package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.loginapp.activities.Home
import com.example.loginapp.mockdata.MockData
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var logInBtn : Button
    private lateinit var emailET : EditText
    private lateinit var passwordET : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity,Home::class.java)
            startActivity(intent)
            finish()
        }
        logInBtn = findViewById(R.id.loginBtn)
        emailET = findViewById(R.id.emailET)
        passwordET = findViewById(R.id.passwordET)
        logInBtn.setOnClickListener{
            Log.i("INGENIERIA", "Boton presionado")
            val email = emailET.text.toString()
            val password = passwordET.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Log.i("INVALID", "invalid credentials")
                Snackbar.make(it, "El correo o contraseña están vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val isValidUser = MockData.users.any{u -> u.email == email && u.password == password }
            if(!isValidUser){
                Snackbar.make(it, "El correo o la contraseña no son validos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity,Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}