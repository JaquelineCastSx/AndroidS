package com.example.loginapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.loginapp.MainActivity
import com.example.loginapp.R

class Home : AppCompatActivity() {
    private lateinit var logoutBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE)
        //logoutBtn = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", false)
            editor.apply()
            val intent = Intent(this@Home,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}