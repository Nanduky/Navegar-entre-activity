package com.nanduky.cursokotlindesde0.sintaxis

/** Las funciones van con el camelCase */

fun main() {
    holaMundo() // Llamar a una función básica
    miEdad(45) // Llamar a una función pasándole un parámetro
    miNumeroFavorito() // Llamar a una función con parámetro por defecto
    sumarValores(16, 54)  // Llamar una fun con retorno de valores
}

/** función básica */
fun holaMundo() {
    println("Hola Mundo")
}

/** función con parámetro de entrada */
fun miEdad(edad: Int) {
    println("Mi edad es de $edad años")
}

/** Función con parámetro por defecto */
fun miNumeroFavorito(numFavorito: Int = 13) {
    println("Mi número favorito es el $numFavorito")
}

/** función con retorno de datos */
/** cuando hay un "return", hay que especificar el tipo de dato que devuelve */
fun sumarValores(valor1: Int, valor2: Int): Int {
    return (valor1 + valor2)
}

/** Se puede simplificar una función cuando sólo hay una sentencia */
fun subtract(valor1: Int, valor2: Int) = valor1 - valor2

