package com.example.barcodeapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barcodeapp.domain.use_cases.getProducts
import com.example.barcodeapp.presentation.events.ProductsEvent
import com.example.barcodeapp.presentation.states.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val prueba : String,
    private val getProducts: getProducts
) : ViewModel(){
    private val _state = MutableStateFlow(ProductState())
    val state = _state.asStateFlow()

    init {
        loadProducts()

    }

    fun onEvent(event : ProductsEvent){
        when(event){
            ProductsEvent.OnDelete -> {

            }
            is ProductsEvent.OnScan -> {
                val barcode = event.barcode
                val product = _state.value.products.find { it.barcode == barcode }
                if(product != null){
                    val updatedList = _state.value.shoppingCartProducts.toMutableList()
                    updatedList.add(product)
                    _state.value = _state.value.copy(shoppingCartProducts = updatedList)
                }else{
                    //Mostrar que el producto no existe

                }
            }
        }
    }

    private fun loadProducts(){
        viewModelScope.launch {
            try {
                val products = getProducts()
                _state.value = ProductState(products = products)
                println(products)
            }
            catch (e : Exception){
                Log.i("ERROR","Falló el metodo get Products")
            }
        }
    }
}