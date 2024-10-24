package com.nanduky.androidmaster.sintaxis

fun main() {
    var name: String = "Fernando"
    //Indice de 0 a 6
    //Tamaño 7

    //declara y asignar valores a un array
    val diasSemana =
        arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    println(diasSemana[0]) // Mstrar un valor segun su indice
    diasSemana[0] = "Feliz lunes" // Cambiar el valor segun el indice
    println(diasSemana[0])

    println(diasSemana.size)  // Mostrar el tamaño de un array
    if (diasSemana.size >= 8) {
        println(diasSemana[7])
    } else println("No hay más valores")

    // Bucles para arrays

    // Nos da la posicion
    for (posicion in diasSemana.indices) {
        println("${posicion + 1}: " + diasSemana[posicion])
    }

    // Nos da la posicion y el valor
    for ((posicion, valor) in diasSemana.withIndex()) {
        println("La posicinon $posicion, contiene $valor")
    }

    // Nos da el valor
    for (valores in diasSemana){
        println("Ahora es $valores")
    }
}