package com.nanduky.cursokotlindesde0.sintaxis

fun main() {
    listaInmutable()
    listaMutable()
}

fun listaInmutable() {
    /** Declarar una lista INMUTABLE (sólo lectura)*/
    val listaInmutableNum: List<String> = listOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
    listaInmutableNum.size  // Obtienes el tamaño de la lista
    listaInmutableNum[0] // Obtienes el valor del índice indicado
    listaInmutableNum.first() // Obtienes el primer valor de la sista
    listaInmutableNum.last() // Obtienes el último valor de la lista
    /** "it" es el iterador, es cada uno de los valores de la lista en cada vuelta del recorrido */
    val filtrar = listaInmutableNum.filter { it.contains("a") } // Filtrar lista

    /** BUCLES PARA LISTAS */
    /** "it" es el iterador, es cada uno de los valores de la lista en cada vuelta del recorrido */
    listaInmutableNum.forEach { println("a): $it") } // Obtienes todos los valores de la lista
    /** sustituye el "it" por una variable con nombre elegido por el usuario */
    listaInmutableNum.forEach { valor -> println("b) $valor") } // Obtienes todos los valores de la lista
}

fun listaMutable() {
    /** Declarar una lista MUTABLE (se puede modificar) */
    val listaMutableNum: MutableList<String> = mutableListOf() // Se puede declara sin valores
    listaMutableNum.addAll(listOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")) // Añadir valores a la lista
    listaMutableNum.add("Seis") //Añadir un valor al final de la lista
    listaMutableNum.add(0, "Cero") //Añadir un valor en el indice especificado
    println(listaMutableNum)

    /** Para comprobar si la lista está vacía o no*/
    if (listaMutableNum.isEmpty()) println("no hay datos")
    else listaMutableNum.forEach { println("c) $it") }

    /** Para comprobar si la lista NO está vacía o no*/
    if (listaMutableNum.isNotEmpty()) listaMutableNum.forEach { println("d) $it") }
    else println("no hay datos")
}