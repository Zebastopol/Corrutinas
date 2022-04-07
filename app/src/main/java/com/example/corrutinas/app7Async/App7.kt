package com.example.corrutinas.app7Async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    asyncAwait()
}

fun asyncAwait(){
    runBlocking {
        println("Paso 1" + System.currentTimeMillis().toString())
       val num1: Int =  async {
            tareaLargaDuracion()
        }.await()
        println("Paso 2" + System.currentTimeMillis().toString())
        val num2: Int =async {
            tareaLargaDuracion()
        }.await()

        println("Paso 3" + System.currentTimeMillis().toString())

    }
}

suspend fun tareaLargaDuracion(): Int{
    delay(timeMillis = 2000)
    println(Thread.currentThread().name)
    return 15
}