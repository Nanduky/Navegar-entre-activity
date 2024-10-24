package com.nanduky.androidmaster.sintaxis

fun main() {
    ifBasico("Fernando")
    ifAnidado("cat")
    ifBoolean(true)
}

fun ifBoolean(soyFeliz: Boolean) {
    //sin nada == true
    //con ! al principio == false
    if (soyFeliz) {
        println("Si, soy feliz")
    } else {
        println("No soy feliz")
    }
}

fun ifAnidado(animal: String) {
    if (animal == "dog") print("Es un perro")
    else if (animal == "cat") println("Es un gato ")
    else println("No es un animal de la lista")

}


fun ifBasico(name: String) {

    if (name == "Fernando") {
        println("Oye, la variable name es Fernando")
    } else {
        println("No eres Fernando")
    }
}