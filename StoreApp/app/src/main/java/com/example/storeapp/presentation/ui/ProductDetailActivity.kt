package com.example.storeapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.storeapp.R
import com.example.storeapp.data.ProductService
import com.example.storeapp.presentation.viewmodels.ProductDetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class ProductDetailActivity : AppCompatActivity() {
    private lateinit var productName: TextView
    private lateinit var productImage: ImageView
    private lateinit var productDescription: TextView
    private lateinit var productPrice: TextView
    private lateinit var productCategory: TextView
    private lateinit var productRating: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val productDetailViewModel : ProductDetailViewModel by viewModels()
        productName = findViewById(R.id.productName)
        productImage = findViewById(R.id.productImage)
        productDescription = findViewById(R.id.productDescription)
        productPrice = findViewById(R.id.productPrice)
        productCategory = findViewById(R.id.productCategory)
        productRating = findViewById(R.id.productRating)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                productDetailViewModel.productState.collect { productState ->
                    if (productState.isLoading) {
                        Log.i("ProductState", "Loading")
                        productName.visibility = TextView.GONE
                        productImage.visibility = ImageView.GONE
                        productCategory.visibility = TextView.GONE
                        productDescription.visibility = TextView.GONE
                        productPrice.visibility = TextView.GONE
                        productRating.visibility = TextView.GONE
                    } else{
                        productName.visibility = TextView.VISIBLE
                        productImage.visibility = ImageView.VISIBLE
                        productCategory.visibility = TextView.VISIBLE
                        productDescription.visibility = TextView.VISIBLE
                        productPrice.visibility = TextView.VISIBLE
                        productRating.visibility = TextView.VISIBLE
                    }
                    if(productState.product != null){
                        Log.i("ProductState", productState.errorMessage)
                        productName.text = productState.product.title
                        Picasso.get().load(productState.product.image).resize(600, 200)
                            .centerInside().into(productImage)
                        productDescription.text = productState.product.description
                        productPrice.text = productState.product.computedPrice
                        productCategory.text = productState.product.category
                        productRating.text = productState.product.rating.rate.toString()

                    }
                }
            }
        }
//        val productId = intent.getIntExtra("productId", 0)
//        Log.i("ProductIntent", productId.toString())
//        getProduct(productId)
    }

    private fun getProduct(id : Int){
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)
        lifecycleScope.launch{
            val response = retrofitBuilder.getProductById(id)
            Log.i("Product Response", response.toString())
            productName.text = response.title
            Picasso.get().load(response.image).resize(600, 200)
                .centerInside().into(productImage)
            productDescription.text = response.description
            productPrice.text = response.computedPrice
            productCategory.text = response.category
            productRating.text = response.rating.rate.toString()
        }
    }
}