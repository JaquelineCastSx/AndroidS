package com.example.barcodeapp.domain.use_cases

import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepositorie
import kotlinx.coroutines.flow.Flow

class getProducts(
    private val repository : ProductRepositorie
) {
    suspend operator fun invoke() : Flow<List<Product>>{
        return repository.getAllProducts()
    }
}