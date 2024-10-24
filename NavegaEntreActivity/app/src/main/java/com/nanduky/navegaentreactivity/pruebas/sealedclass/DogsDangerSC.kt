package com.nanduky.navegaentreactivity.pruebas.sealedclass

sealed class DogsDangerSC() {
    object NoDanger : DogsDangerSC()
    object LightDanger : DogsDangerSC()
    object MediumDanger : DogsDangerSC()
    object VeryDanger : DogsDangerSC()
    data class DevilDanger(val devilNane:String):DogsDangerSC()
    data class EliminationDevil(val levelDevil:LevelDevil):DogsDangerSC()
}

sealed class LevelDevil(){
    object NoEliminar:LevelDevil()
    object Cuidado:LevelDevil()
    object Cuarentena:LevelDevil()
    object Eliminar:LevelDevil()
    object EliminarQuemar:LevelDevil()
    data class Rabioso(val rabia:String):LevelDevil()
}