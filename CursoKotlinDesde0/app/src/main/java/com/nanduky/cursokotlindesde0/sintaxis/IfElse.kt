package com.nanduky.cursokotlindesde0.sintaxis

const val DIA: String = "Viernes"
const val FESTIVO: Boolean = false

fun main() {
    ifBasico(DIA)
    ifAnidado(DIA)
    ifBoolean(FESTIVO)
}

/** Un if básico */
fun ifBasico(dia: String) {
    if (dia == "Viernes") {
        /** si la comparación es correcta executable este codigo */
        println("La comparación es igual")
    } else {
        /** Si la comparación no es correcta se ejecuta este codigo */
        println("La comparación no es igual")
    }
    /** Esto se puede simplificar siempre que haya una sóla sentencia */
    if (dia == "Lunes") println("Si es correcto")
    else println("No es correcto")

}

/** Un else if anidado pero esto no es óptimo, lo ideal son los when*/
fun ifAnidado(dia: String) {
    if (dia == "Lunes") println("Hoy es Lunes")
    else if (dia == "Viernes") println("Hoy es Viernes")
    else println("No es ningún día seleccionado")
}

/** Un if con un Boolean */
fun ifBoolean(festivo: Boolean) {
    if (festivo) println("Es festivo") //si es true
    if (!festivo) println("No ess festivo") //si es false
}


