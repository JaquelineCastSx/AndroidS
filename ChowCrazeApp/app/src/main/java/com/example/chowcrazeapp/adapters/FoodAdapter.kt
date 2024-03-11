package com.example.chowcrazeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Food
import com.squareup.picasso.Picasso

class FoodAdapter(val foods:List<Food>, val onClick:(Food)->Unit):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    class FoodViewHolder(view: View):RecyclerView.ViewHolder(view){
        val foodImageView : ImageView = view.findViewById(R.id.food_image)
        val foodNameTextView : TextView = view.findViewById(R.id.food_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.foodNameTextView.text = food.name
        Picasso.get().load(food.image).into(holder.foodImageView)
        holder.itemView.setOnClickListener{
            onClick(food)
        }
    }
}