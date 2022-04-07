package com.example.corrutinas.app4suspencionrunblockingdispatcher

import kotlinx.coroutines.*

fun main() {

    println("Tarea1 " + Thread.currentThread().name)

    //Dispatcher Unconfined es para que el hilo se ejecute y no importe desde donde se ejecute
    runBlocking (Dispatchers.Unconfined){
        delayCorrutina("Tarea2 ")
    }
    // Este Dispatcher es para ser ejecutado en el uso de operaciones de uso intensivo de la CPU
    runBlocking (Dispatchers.Default){
        delayCorrutina("Tarea3 ")
    }
    // Para que el Hilo se ejecute con entrada y salida de datos (Webservice, BD, Archivo, etc..)
    runBlocking (Dispatchers.IO){
        delayCorrutina("Tarea4 ")
    }
    runBlocking (newSingleThreadContext("MiHilo")){
        delayCorrutina("Tarea5 ")
    }
    /* se ejecuta dentro del hilo principal del main activity
    runBlocking(Dispatchers.Main){
        delayCorrutina("Tarea6 ")
    } */

    runBlocking(newFixedThreadPoolContext(2,"Pool de Corrutinas")){
        delayCorrutina("Accion 3")
    }
    println("Tarea7 " + Thread.currentThread().name)

}

fun tareaLargaDuracion(mensaje: String) {
    println(mensaje + Thread.currentThread().name)
    Thread.sleep(10000)

}

suspend fun delayCorrutina(mensaje: String){
    println(mensaje + Thread.currentThread().name)
    delay(timeMillis = 10000)
}