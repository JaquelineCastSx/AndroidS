package com.example.chowcrazeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.chowcrazeapp.models.Restaurant

class RestaurantActivity : AppCompatActivity() {
    private lateinit var restaurantTxtView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val restaurantId = intent.getIntExtra("restaurantId", 0)
        val restaurant = Restaurant.restaurants.find { it.id == restaurantId }
        restaurantTxtView = findViewById(R.id.restaurant_name_title)
        restaurantTxtView.text = restaurant?.name
    }
}