package com.nanduky.navegaentreactivity.pruebas.sealedclass

data class DogsCompany(
    val raceDog: String,
    val nameDog: String,
    val colorDog: String,
    val sizeDog: String,
    val dangerDog: DogsDangerSC,
    val elimination: DogsDangerSC.EliminationDevil
)
