package com.example.barcodeapp.domain.use_cases

import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepositorie

class getProducts(
    private val repository : ProductRepositorie
) {
    suspend operator fun invoke() : List<Product>{
        return repository.getAllProducts()
    }
}