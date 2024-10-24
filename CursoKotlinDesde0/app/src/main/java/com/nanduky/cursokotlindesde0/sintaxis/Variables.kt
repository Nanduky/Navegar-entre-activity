package com.nanduky.cursokotlindesde0.sintaxis

const val VARIABLE_DE_CLASE: Int = 55 // Una variable de clase puede acceder toda la clase

fun main() {
    val variableDeFuncion: String = "Texto" // Una variable de función sólo puede acceder su función

    /** Como declara variables o valores: (Se puede especificar el tipo, pero no es necesario)*/
    /** Variables numéricas */
    /** Int */
    val intValEdad: Int = 30 // == val intEdad = 30
    var intVarEdad: Int = 30 // == var intEdad2 = 30

    /** Long ( como Int pero usa más memoria del pc que los Int) */
    val longValEjemplo: Long = 30000 // == val longEjemplo = 30000
    var longVarEjemplo: Long = 30000 // == val longEjemplo = 30000

    /** Float, esta soporta números decimales, hasta 6 decimales precedido de la "f" */
    val floatValEjemplo: Float = 30.0f

    // Double, soporta 14 decimales y consume más memoria que lo Float
    val doubleValEjemplo: Double = 35.2654
    var doubleVarEjemplo: Double = 35.2654

    /** Variables alfanúmericas */
    /** Char, sólo soporta un carácter (entre comillas simples). */
    val charValEjemplo1: Char = 'e'
    val charValEjemplo2: Char = '2' // No es numérico
    val charValEjemplo3: Char = '@'

    /**  String vale para todo */
    val stringValEjemplo: String = "Texto lo "
    val stringVarEjemplo: String = " que sea "

    /** String Multilíneas  */
    val strMulLin: String = """        
           |Esto es un texto de pruebas Multilíneas 
        |con un parámetro final que se puede cambiar 
                |según lo que busques
    """.trimMargin()

    /** Variables booleanas */
    /** Boolean, verdadero o falso */
    var booleanEjemplo1: Boolean = true
    var booleanEjemplo2: Boolean = false

    /** Para convertir un tipo de valor a otro */
    val newInt: Int = floatValEjemplo.toInt() // newInt = 30

    /** Concatenar Strins */
    val strConca01: String = stringValEjemplo + stringVarEjemplo // Texto lo que sea

    /** Concatenar String con una variable se usará el símbolo $ */
    val strConca02: String = " Mi edad es de $intValEdad " //Mi edad es de 30

    /** Concatenar con .plus() */
    val strConca03: String = strConca01.plus(strConca02) // Texto lo  que sea  Mi edad es de 30

    /** Concatenar con StringBuilders "Recomendado Kotlin"*/
    val strConca04: String =
        StringBuilder(strConca01).append(strConca02)
            .toString() // Texto lo  que sea  Mi edad es de 30

    /** Concatenar usando .joinToString("") */
    val list = listOf("Hola", "Mundo", "Tierra", "Nuevo")
    val strConca05 = list.joinToString("", "[", "]", 3) // [HolaMundoTierra...]

    /** Concatenar con ${...} */
    val strConca06 = "Sumando variables ${intValEdad + intVarEdad}" // Sumando variables 60



    println(strConca06)

}