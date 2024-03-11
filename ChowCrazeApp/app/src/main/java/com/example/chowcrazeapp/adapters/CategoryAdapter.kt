package com.example.chowcrazeapp.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Category
import com.squareup.picasso.Picasso

class CategoryAdapter(val categories:List<Category>):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val categoryImage: ImageView = itemView.findViewById(R.id.category_image_view)
        val categoryName: TextView = itemView.findViewById(R.id.category_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryName.text  = category.name
        Picasso.get().load(category.image).into(holder.categoryImage)
    }
}