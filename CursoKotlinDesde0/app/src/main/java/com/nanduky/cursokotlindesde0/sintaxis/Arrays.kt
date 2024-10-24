package com.nanduky.cursokotlindesde0.sintaxis

fun main() {
    /** Declarar una variable con valores*/
    val numerosLetras = arrayOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
    numerosLetras[0] // Selecciona un valor por su índice
    numerosLetras.size // Muestra el tamaño del array
    numerosLetras[0] = "Primer número" // Cambiar un dato en un array

    /** BUCLES PARA ARRAYS */
    for (posicion in numerosLetras.indices) { // Recorrer el array
        println(numerosLetras[posicion])
    }

    for ((posicion, valor) in numerosLetras.withIndex()) {
        println("index: $posicion = $valor") // obtener el índice y/o el valor del array
    }

    for (valorNumerosLetras in numerosLetras) {
        println("Valor: $valorNumerosLetras") //obtener el valor del array
    }

    numerosLetras.forEach { println(it) } // Recorre todo el array
    numerosLetras.forEach { valor -> println(valor) } // Lo mismo de arriba sustituyendo el "it"
}