package com.example.fragmentsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsapp.Adapters.SimpleAdapter
import com.example.fragmentsapp.R


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //Uso del adapter para insertar el recycleview en el espacio del main
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val languages = listOf<String>(
            "English",
            "Mandarin Chinese",
            "Spanish",
            "Hindi",
            "Arabic",
            "French",
            "Bengali",
            "Russian",
            "Portuguese",
            "Urdu"
        )
        val recycleView = view.findViewById<RecyclerView>(R.id.home_recycleview)
        recycleView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = SimpleAdapter(languages)
    }
}