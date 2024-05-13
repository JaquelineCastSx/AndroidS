package com.example.roomprojectapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.roomprojectapp.R
import com.example.roomprojectapp.domain.models.Player
import com.squareup.picasso.Picasso

class PlayerDetailActivity : AppCompatActivity() {
    private lateinit var playerName : TextView
    private lateinit var playerPosition : TextView
    private lateinit var playerImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Asigna a las variables su elemento del layout
        setContentView(R.layout.activity_player_detail)
        playerName = findViewById(R.id.nameTV)
        playerPosition = findViewById(R.id.positionTV)
        playerImage = findViewById(R.id.imageView)

        val player = intent.getSerializableExtra("player") as Player

        //Asigna la informacion del jugador en cada campo del layout
        playerName.text = player.name
        playerPosition.text = player.position
        Picasso.get().load(player.imagen).resize(600, 200)
            .centerInside().into(playerImage)
    }
}