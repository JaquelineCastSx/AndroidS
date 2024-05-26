package com.example.storeapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.storeapp.R
import com.example.storeapp.domain.models.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(
    private val products: List<Product>,
    val onProductClick : (Product) -> Unit
) : RecyclerView.Adapter<ProductsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        holder.categoryTV.text = product.category
        holder.priceTV.text = product.computedPrice
        holder.titleTV.text = product.computedTitle
        holder.ratingTV.text = product.rating.rate.toString()
        Picasso.get().load(product.image).resize(600, 200)
            .centerInside().into(holder.imageV)

        holder.itemView.setOnClickListener{
            onProductClick(product)
        }
    }

}

class ProductsViewHolder(view:View) : RecyclerView.ViewHolder(view){
    val categoryTV : TextView
    val priceTV : TextView
    val imageV : ImageView
    val titleTV : TextView
    val ratingTV : TextView

    init {
        categoryTV = view.findViewById(R.id.productCategory)
        priceTV = view.findViewById(R.id.product_price)
        imageV = view.findViewById(R.id.productImage)
        titleTV = view.findViewById(R.id.productName)
        ratingTV = view.findViewById(R.id.product_rating)
    }
}