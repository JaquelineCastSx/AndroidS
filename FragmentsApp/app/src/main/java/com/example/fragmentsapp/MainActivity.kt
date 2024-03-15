package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragmentsapp.fragments.BuyFragment
import com.example.fragmentsapp.fragments.CategoryFragment
import com.example.fragmentsapp.fragments.HomeFragment
import com.example.fragmentsapp.fragments.ProductsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavbar : BottomNavigationView
    private var MainActivityTag = "MENU_ITEM"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declara la barra de navegacion
        bottomNavbar = findViewById(R.id.bottom_nav_menu)
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit()
        bottomNavbar.setOnItemSelectedListener {menuItem ->
            //Listener de la barra de navegacion que abre el fragment segun el boton donde se haga click
            when(menuItem.itemId){
                R.id.home_menu -> {
                    Log.i(MainActivityTag, "Home seleccionado")
                    //Le indica al main donde se va a insertar el fragment seleccionado
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit()
                }
                R.id.category_menu ->{
                    Log.i(MainActivityTag, "Category seleccionado")
                    val categoryFragment = CategoryFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, categoryFragment).commit()
                }
                R.id.buy_menu ->{
                    Log.i(MainActivityTag, "Buy seleccionado")
                    val buyFragment = BuyFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, buyFragment).commit()
                }
                R.id.product_menu ->{
                    Log.i(MainActivityTag, "Product seleccionado")
                    val productFragment = ProductsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, productFragment).commit()
                }
            }
            true
        }
    }
}