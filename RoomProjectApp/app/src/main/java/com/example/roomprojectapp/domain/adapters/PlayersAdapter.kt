package com.example.roomprojectapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomprojectapp.R
import com.example.roomprojectapp.domain.models.Player
import com.squareup.picasso.Picasso

class PlayersAdapter(
    private val players: List<Player>,
    val onClick : (Player) -> Unit
) : RecyclerView.Adapter<PlayerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.playerTV.text = player.name
        holder.positionTV.text = player.position
        Picasso.get().load(player.imagen).resize(600, 200)
            .centerInside().into(holder.imageV)
        holder.itemView.setOnClickListener {
            onClick(player)
        }
    }

    

}
class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val playerTV : TextView
    val positionTV : TextView
    val imageV : ImageView

    init {
        playerTV = view.findViewById(R.id.tvPlayerName)
        positionTV = view.findViewById(R.id.tvPlayerPosition)
        imageV = view.findViewById(R.id.imgPlayer)
    }
}