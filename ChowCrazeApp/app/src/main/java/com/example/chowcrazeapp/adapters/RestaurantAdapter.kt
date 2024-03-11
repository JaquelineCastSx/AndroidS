package com.example.chowcrazeapp.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Restaurant
import com.squareup.picasso.Picasso

class RestaurantAdapter(val restaurants:List<Restaurant>, val onClick:(Restaurant)->Unit) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {
    class RestaurantViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val restaurantTxtView : TextView = view.findViewById(R.id.restaurant_name)
        val restaurantImg : ImageView = view.findViewById(R.id.restaurant_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item,parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantTxtView.text = restaurant.name
        Picasso.get().load(restaurant.image).into(holder.restaurantImg)
        holder.view.setOnClickListener{
            onClick(restaurant)
        }
    }
}