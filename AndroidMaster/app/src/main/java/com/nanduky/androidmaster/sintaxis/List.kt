package com.nanduky.androidmaster.sintaxis

fun main() {
    // inmutableList()
    mutableList()
}

fun mutableList() {
    val weekDays: MutableList<String> = mutableListOf(
        "Lunes", "Martes", "Miércoles", "Jueves",
        "Viernes", "Sábado", "Domingo"
    )
    println("Toda las lista: $weekDays ")

    // Añadir valor a la ultima posicion
    weekDays.add("NandukyDay")
    println("Toda las lista: $weekDays ")

    // Añadir valor a la primera posición
    weekDays.add(0, "NandukyDay2")
    println("Toda las lista: $weekDays ")

    // Pregunta si está vacía
    if (weekDays.isEmpty()) {
    } else {
        var i = 0
        weekDays.forEach {
            println("Dia $i: $it")
            i++
        }
    }

    //Para preguntar si NO está vacía
    if (weekDays.isNotEmpty()) {
        println("La lista no está vacia")
    } else {
        println("La lista está vacia")
    }
}


fun inmutableList() {
    // Lista inmutable, no cambia de tamaño
    val readOnly: List<String> = listOf(
        "Lunes", "Martes", "Miércoles", "Jueves",
        "Viernes", "Sábado", "Domingo"
    )
    println("Tamaño: " + readOnly.size)
    println("Toda las lista: $readOnly ")
    println("Posición fija: " + readOnly[0])
    println("Ultima posición: " + readOnly.last())
    println("primera posición: " + readOnly.first())

    //if seria como una variable que recorre todos los valores
    val ejemplo = readOnly.filter { it.contains("a") }
    println("Contitnen la letra \"a\": $ejemplo")

    readOnly.forEach { println("dia Semana: $it") }
    // it pasa a nmbrarse diaSemana
    readOnly.forEach { diaSemana -> println(diaSemana) }
}