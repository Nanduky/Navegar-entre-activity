package com.nanduky.androidmaster.sintaxis

fun main() {
    val month = 15
    getMonth(month)
    getTrimestre(month)
    getSemestre(month)
    resultado(53)
}

fun resultado(value: Any) {
    when (value) {
        is Int -> println(value + value)
        is String -> println("value es $value")
        is Boolean -> if (value) {
            println("value es verdadero")
        } else {
            println("value es falso")
        }
    }
}

fun getSemestre(month: Int): String {
    return when (month) {
        in 1..6 -> "El mes $month pertenece al primer semestre"
        in 7..12 -> "El mes $month pertenece al segundo semestre"
        !in 1..12 -> "El mes $month no pertenece a ningún semestre"
        else -> "nada"
    }
}

fun getTrimestre(month: Int) {
    when (month) {
        1, 2, 3 -> println("El mes $month pertenece al primer trimestre")
        4, 5, 6 -> println("El mes $month pertenece al segundo trimestre")
        7, 8, 9 -> println("El mes $month pertenece al tercer trimestre")
        10, 11, 12 -> println("Els mes $month pertenece al cuarto trimestre")
        else -> println("El mes $month no pertenece a ningún trimestre")
    }
}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("El mes $month corresponde al mes de enero")
        2 -> println("El mes $month corresponde al mes de febrero")
        3 -> println("El mes $month corresponde al mes de marzo")
        4 -> println("El mes $month corresponde al mes de abril")
        5 -> println("El mes $month corresponde al mes de mayo")
        6 -> println("El mes $month corresponde al mes de junio")
        7 -> println("El mes $month corresponde al mes de julio")
        8 -> {
            println("El mes $month corresponde al mes de agosto")
            println("Y es el mes de las vacaciones")
        }

        9 -> println("El mes $month corresponde al mes de septiembre")
        10 -> println("Els mes $month corresponde al mes de octubre")
        11 -> println("El mes $month corresponde al mes de noviembre")
        12 -> println("El mes $month corresponde al mes de diciembre")
        else -> println("El mes $month no es ningún mes valido")
    }
}