package com.example.barcodeapp.solid

interface IAnimal{
    fun comer()
}
interface  IAnimalvolador{
    fun volar()
}

interface IAnimalNadador{
    fun nadar()
}

interface IAnimalAndador{
    fun caminar()
}

class Perro : IAnimal, IAnimalNadador, IAnimalAndador{
    override fun comer() {
        TODO("Not yet implemented")
    }

    override fun nadar() {
        TODO("Not yet implemented")
    }

    override fun caminar() {
        TODO("Not yet implemented")
    }

}