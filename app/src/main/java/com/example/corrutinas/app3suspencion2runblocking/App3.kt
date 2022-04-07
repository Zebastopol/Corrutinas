package com.example.corrutinas.app3suspencion2runblocking

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    println("Tarea1 " + Thread.currentThread().name)

    //ejecuta la corrutina
    runBlocking {
        delayCorrutina("Tarea2 ")
    }
    println("Tarea3 " + Thread.currentThread().name)

}


suspend fun delayCorrutina(mensaje: String){
    println(mensaje + Thread.currentThread().name)
    delay(timeMillis = 10000)
}