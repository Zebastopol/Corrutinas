package com.example.corrutinas.app9TiempoEsperaAsync

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    asyncAwait()
    println("Demora asyncAwait" + measureTimeMillis { asyncAwait() })
    println("Demora asyncAwaitDeferred " + measureTimeMillis { asyncAwaitDeferred() })
}

    fun asyncAwait() {
        runBlocking {
            println("Paso 1" + System.currentTimeMillis().toString())
            val num1: Int = async {
                tareaLargaDuracion()
            }.await()
            println("Paso 2" + System.currentTimeMillis().toString())
            val num2: Int = async {
                tareaLargaDuracion()
            }.await()

            println("Paso 3" + System.currentTimeMillis().toString())

        }
    }
    fun asyncAwaitDeferred() {
        runBlocking {
            println("Paso 1" + System.currentTimeMillis().toString())
            val num1: Deferred<Int> = async {
                com.example.corrutinas.app8AsyncDeferred.tareaLargaDuracion()
            }
            println("Paso 2" + System.currentTimeMillis().toString())
            val num2: Deferred<Int> = async {
                com.example.corrutinas.app8AsyncDeferred.tareaLargaDuracion()
            }

            println("Paso 3" + System.currentTimeMillis().toString())
            val resultado: Int = num1.await() + num2.await()
            println(resultado)
        }
    }

suspend fun tareaLargaDuracion(): Int {
    delay(timeMillis = 2000)
    println(Thread.currentThread().name)
    return 15
}
