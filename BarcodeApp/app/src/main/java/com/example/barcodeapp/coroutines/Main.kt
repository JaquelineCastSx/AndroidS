package com.example.barcodeapp.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val SEPARATOR = "======================"
/*
* Rutina = Trabajadores
* Scoping = Espacio de trabajo
* */
fun newTopic(topic:String){
    println("\n $SEPARATOR $topic $SEPARATOR")
}
fun main(){
    newTopic("Corrutinas")
//    globalScope()
//    println("Desde el hilo principal")
//    GlobalScope.launch {
//        suspendFun()
//    }
    newTopic("Constructores")
//    cRunBlocking()
//    cLaunch()
//    cAsync()
    job()
    readln()
}

fun globalScope(){
    newTopic("Global Scope")
    // GlobalScope ejecuta corrutinas durante todo el proyecto, es mala practica
    GlobalScope.launch {
        println("Mi primera corrutina")
        delay(2000)
        println("Trabajando en otra cosa")
    }
}

//Funcion suspendida, debe ser ejecutada dentro de una corrutina
suspend fun suspendFun(){
    newTopic("Suspend Fun")
    println("Recopilando datos")
    delay(2000)
    println("Terminado")
}

fun cRunBlocking(){
    //Sirve para mostrar el funcionamiento de corrutinas, no se usa realmente
    newTopic("Run Blocking")
    runBlocking {
        println("Inicia de consulta API")
        delay(1000)
        println("Finalizó")
    }
}

fun cLaunch(){
    newTopic("Launch")
    runBlocking {
        //Launch = Corrutina que ejecuta tareas (como void) regresa un job
        launch {
            println("Launch")
            delay(2000)
            println("Trabajando en otra cosa")
        }
    }
}

fun cAsync(){
    newTopic("Async")
    runBlocking {
        val result = async {
            println("Consulta a BD")
            delay(1000)
            "Datos"
        }
        println("Resultado: ${result.await()}")
    }
}

fun job(){
    newTopic("Job")
    runBlocking {
        val job = launch {
            println("Inico de peticion API")
            delay(1000)
            println("Datos extraidos")
            println("End job")
        }
        delay(500)
        println("IsActive: ${job.isActive}")
        println("IsCompleted: ${job.isCompleted}")
        println("IsCancelled: ${job.isCancelled}")

        println("Tarea cancelada")
        job.cancel()

        println("IsActive: ${job.isActive}")
        println("IsCompleted: ${job.isCompleted}")
        println("IsCancelled: ${job.isCancelled}")
    }
}