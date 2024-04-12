package com.example.barcodeapp.data.repositories

import com.example.barcodeapp.data.dao.ProducDAO
import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepositorie
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao : ProducDAO
) : ProductRepositorie {
    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

}