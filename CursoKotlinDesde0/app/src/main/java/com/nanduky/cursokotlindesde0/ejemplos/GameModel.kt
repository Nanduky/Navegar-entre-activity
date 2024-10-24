package com.nanduky.cursokotlindesde0.ejemplos

/** data Class para la lista de juegos */
data class GameModel(val titulo: String, val numeroSerie: String, val error: GameError)

/** Creamos la sealed class */
sealed class GameError() {
    /** creamos los objetos de cada error que son del tipo GameError */
    /** Los objetos de las sealed class van en mayúscula la primera letra */
    object RayadoError : GameError()
    object InternetError : GameError()
    object NoError : GameError()
    object CongeladoError : GameError() // Nuevo error
    /** Otro error pero con parámetros */
    data class VersionError(val version: String) : GameError() // Error con parámetros
}