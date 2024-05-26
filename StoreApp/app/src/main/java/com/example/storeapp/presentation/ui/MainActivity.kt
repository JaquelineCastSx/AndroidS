package com.example.storeapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.storeapp.R
import com.example.storeapp.data.ProductService
import com.example.storeapp.domain.adapters.ProductsAdapter
import com.example.storeapp.domain.models.Product
import com.example.storeapp.presentation.viewmodels.ProductsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var productsAdapter : ProductsAdapter
    private lateinit var progressBar : ProgressBar
    private var productList = emptyList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productsViewModel : ProductsViewModel by viewModels()
        recyclerView = findViewById(R.id.recycleView)
        progressBar = findViewById(R.id.progress_Bar)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                productsViewModel.productsState.collect { state ->
                    val products = state.products
                    if (state.isLoading){
                        progressBar.visibility = ProgressBar.VISIBLE
                        recyclerView.visibility = RecyclerView.GONE
                    }
                    else{
                        progressBar.visibility = ProgressBar.GONE
                        recyclerView.visibility = RecyclerView.VISIBLE
                    }

                    if (state.errorMessage.isNotEmpty()){
                        Snackbar.make(this@MainActivity, recyclerView, state.errorMessage, Snackbar.LENGTH_LONG).show()
                    }

                    recyclerView.adapter = ProductsAdapter(productList){
                        val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
                            .apply {
                                putExtra("productId", it.id)
                            }
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun getProducts(){
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)

        lifecycleScope.launch {
            val response = retrofitBuilder.getProducts()
            Log.i("Product Response", response.toString())

        }
    }
}