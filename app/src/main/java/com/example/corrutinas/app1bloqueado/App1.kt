package com.example.corrutinas.app1bloqueado


fun main(){

    println("Tarea1 " + Thread.currentThread().name)
    tareaLargaDuracion("Tarea2 ")
    println("Tarea3 " + Thread.currentThread().name)

}

fun tareaLargaDuracion(mensaje: String){
    println(mensaje + Thread.currentThread().name)
    Thread.sleep(10000)

}

fun devuelveUnNumero(): Int{
    Thread.sleep(2000)
    return (1 + 1)
}