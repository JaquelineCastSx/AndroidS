package com.example.fragmentsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsapp.Adapters.SimpleAdapter
import com.example.fragmentsapp.R

class BuyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy, container, false)
    }
    //Uso del adapter para insertar el recycleview en el espacio del main
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foods = listOf<String>(
            "Pizza",
            "Sushi",
            "Tacos",
            "Pasta",
            "Burger",
            "Curry",
            "Ramen",
            "Croissant",
            "Samosa",
            "Steak"
        )

        val recycleView = view.findViewById<RecyclerView>(R.id.buy_recycleview)
        recycleView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = SimpleAdapter(foods)
    }
}