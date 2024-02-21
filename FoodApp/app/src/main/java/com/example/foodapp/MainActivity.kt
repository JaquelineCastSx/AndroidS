package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var compraBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compraBtn = findViewById(R.id.compraBtn)
        compraBtn.setOnClickListener{
            val intent = Intent(this@MainActivity,compra::class.java)
            startActivity(intent)
        }
    }
}