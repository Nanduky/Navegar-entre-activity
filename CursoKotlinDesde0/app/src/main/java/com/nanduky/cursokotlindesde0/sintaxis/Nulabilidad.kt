package com.nanduky.cursokotlindesde0.sintaxis


/** Las variables pueden ser nulas asignandoles el ? al final */
fun main() {
    var name: String? = null
    println(name?.get(0))  // con el ? se le dice que si no es null, haga algo
    println(name?.get(8) ?: "Es nulo") // en caso de que sea null haz otra cosa
}


