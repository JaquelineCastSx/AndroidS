package com.example.barcodeapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barcodeapp.R
import com.example.barcodeapp.domain.adapters.ProductAdapter
import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.presentation.viewmodels.MainViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var button :Button
    private lateinit var productsRecycleview : RecyclerView
    private val products = mutableListOf<Product>()
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btnScan)
        setUpRecycleView()
        button.setOnClickListener{
            scanCode()
        }
        Toast.makeText(this,mainViewModel.getString(), Toast.LENGTH_LONG).show()
    }

    private fun setUpRecycleView(){
        productsRecycleview = findViewById(R.id.rv_products)
        productsRecycleview.adapter = ProductAdapter(products)
        productsRecycleview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun scanCode(){
        val options = ScanOptions()
        options.setPrompt("Escanee un código de barras")
        options.setBeepEnabled(true)
        options.setOrientationLocked(true)
        barcodeLauncher.launch(options)
    }

    private val barcodeLauncher = registerForActivityResult(ScanContract()){ result ->
        if(result.contents == null){
            //El usuario cerro la camara sin escanear
            Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
        }else{
            val product = Product.products.find { p -> p.barcode == result.contents }
            if(product != null){
                products.add(product)
                productsRecycleview.adapter?.notifyDataSetChanged()
                Toast.makeText(this, "Escaneado: ${result.contents}", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_LONG).show()
            }

        }
    }
}