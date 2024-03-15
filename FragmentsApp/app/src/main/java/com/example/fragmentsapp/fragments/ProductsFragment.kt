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


class ProductsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }
    //Uso del adapter para insertar el recycleview en el espacio del main
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val houseProducts = listOf<String>(
            "Toilet paper",
            "Dish soap",
            "Laundry detergent",
            "Paper towels",
            "Bleach",
            "Trash bags",
            "Broom",
            "Vacuum cleaner",
            "Light bulbs",
            "Sponges"
        )

        val recycleView = view.findViewById<RecyclerView>(R.id.product_recycleview)
        recycleView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = SimpleAdapter(houseProducts)
    }
}