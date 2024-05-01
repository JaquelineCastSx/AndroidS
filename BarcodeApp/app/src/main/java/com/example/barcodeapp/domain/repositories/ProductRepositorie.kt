package com.example.barcodeapp.domain.repositories

import com.example.barcodeapp.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepositorie {
    suspend fun getAllProducts() : Flow<List<Product>>
}