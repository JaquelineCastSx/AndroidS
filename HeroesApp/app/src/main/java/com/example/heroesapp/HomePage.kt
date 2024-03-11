package com.example.heroesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.Adapters.PublisherAdapter
import com.example.heroesapp.models.Publisher

class HomePage : AppCompatActivity() {
    private lateinit var publisherRecyclerView :RecyclerView
    private lateinit var logoutBtn : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        publisherRecyclerView = findViewById(R.id.publisher_recycler_view)
        publisherRecyclerView.adapter = PublisherAdapter(Publisher.publishers){

            val intent = Intent(this,HeroesActivity::class.java)
            startActivity(intent)
        }
        publisherRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE)
        logoutBtn = findViewById(R.id.btnOut)
        logoutBtn.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", false)
            editor.apply()
            val intent = Intent(this@HomePage,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}