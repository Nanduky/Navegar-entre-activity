package com.nanduky.cursokotlindesde0.sintaxis

const val MES: Int = 7
fun main() {
    selectMes(MES)
    selectTrimestre(MES)
    selectSemestre(MES)
    println("Retorno de dato: ${retornoDatos(MES)}")
    println("Retorno de dato mejorado: ${retornoDatosMejorado(MES)}")
    println("Retorno de dato Re_mejorado: ${retornoDatosReMejorado(MES)}")
    comprobarObjeto(MES)


}

/**
 * El when recorre todas los opciones y selecciona la de la variable
 * en el caso de más de una sentencia, deven ponerse las llave {...}
 * */
/** when con un solo resultado */
fun selectMes(mes: Int) {
    when (mes) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> {
            println("Agosto")
            println(" mes de vacaciones")
        }

        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("No es un mes valido")
    }
}

/** when con varios valores con el mismo resultados */
fun selectTrimestre(mes: Int) {
    when (mes) {
        1, 2, 3 -> println("Primer trimestre")
        4, 5, 6 -> println("Segundo trimestre")
        7, 8, 9 -> println("Tercer trimestre")
        10, 11, 12 -> println("Cuarto trimestre")
        else -> println("No es un trimestre válido")
    }

}

/** when con un rango de valores con el mismo resultado */
fun selectSemestre(mes: Int) {
    when (mes) {
        in 1..6 -> println("Primer semestre")
        in 7..12 -> println("Segundo semestre")
        !in 1..12 -> println("No es un semestre válido")
    }

}

/** when con devolución de datos */
fun retornoDatos(mes: Int): String {
    val dato: String = when (mes) {
        in 1..6 -> "Primer semestre"
        in 7..12 -> "Segundo semestre"
        !in 1..12 -> "No es un semestre válido"
        else -> "No es un dato correcto"
    }
    return dato
}

/** when con devolución de datos mejorado */
fun retornoDatosMejorado(mes: Int): String {
    return when (mes) {
        in 1..6 -> "Primer semestre"
        in 7..12 -> "Segundo semestre"
        !in 1..12 -> "No es un semestre válido"
        else -> "No es un dato correcto"
    }

}

fun retornoDatosReMejorado(mes: Int) = when (mes) {
    in 1..6 -> "Primer semestre"
    in 7..12 -> "Segundo semestre"
    !in 1..12 -> "No es un semestre válido"
    else -> "No es un dato correcto"
}

/** Comprobar que tipo de objeto es con when  */
fun comprobarObjeto(mes: Any) {
    when (mes) {
        is Int -> println(mes + mes)
        is String -> println(mes)
        is Boolean -> if (mes) println("Es true")
    }
}