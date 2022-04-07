package com.example.corrutinas.app5launch

import com.example.corrutinas.app4suspencionrunblockingdispatcher.delayCorrutina
import kotlinx.coroutines.*

fun main() {

    println("Tarea1 " + Thread.currentThread().name)


    GlobalScope.launch {
        delayCorrutina("Tarea2 ")
    }

    println("Tarea3 " + Thread.currentThread().name)

    Thread.sleep(11000)

}

suspend fun delayCorrutina(mensaje: String){
    println(mensaje + Thread.currentThread().name)
    delay(timeMillis = 10000)
}