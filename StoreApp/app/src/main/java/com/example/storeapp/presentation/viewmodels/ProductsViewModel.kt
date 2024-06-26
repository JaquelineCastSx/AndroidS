package com.example.storeapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.use_cases.GetProducts
import com.example.storeapp.presentation.ApiResult
import com.example.storeapp.presentation.states.ProductsState
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltAndroidApp
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase : GetProducts
) : ViewModel(){
    private var productsJob : Job? = null
    private var _productsState = MutableStateFlow(ProductsState())
    val productsState = _productsState.asStateFlow()

    init {
        //Llamado a los productos
        getProducts()
    }

    private fun getProducts(){
        productsJob?.cancel()
        productsJob = getProductsUseCase().onEach {result ->
            when(result){
                is ApiResult.Loading ->{
                    //Decir al usuario q la app esta cargando
                    _productsState.value = ProductsState(isLoading = true)
                }

                is ApiResult.Error ->{
                    //Decir al usuario q la app tiene un error
                    _productsState.value = ProductsState(errorMessage = result.message ?: "")
                }

                is ApiResult.Success ->{
                    //Mostrar la lista de productos
                    _productsState.value = ProductsState(products = result.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}