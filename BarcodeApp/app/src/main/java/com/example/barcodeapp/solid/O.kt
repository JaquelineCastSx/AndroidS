package com.example.barcodeapp.solid

open class Calculadora{
    fun sumar(a:Int, b:Int) : Int = a + b
    fun restar(a:Int, b:Int) : Int = a - b
}

class CalculadoraCientífica : Calculadora(){
    fun raizCuadrada(){
        //Funcion de raiz cuadrada
    }
}