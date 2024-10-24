package com.nanduky.navegaentreactivity.pruebas.sealedclass

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.pruebas.sealedclass.DogsDangerSC.*

class SealedClass03Activity : AppCompatActivity() {

    private val dogsList = listOf<DogsCompany>(
        DogsCompany("Colier", "Vety", "Blanca", "pequeña", NoDanger,
            EliminationDevil(LevelDevil.NoEliminar)),
        DogsCompany("Terrier", "Terry", "Marron", "Mediano", LightDanger,
            EliminationDevil(LevelDevil.Cuidado)),
        DogsCompany("Aleman", "Floky", "Negra", "Grande", MediumDanger,
            EliminationDevil(LevelDevil.Cuarentena)),
        DogsCompany("Pitbull", "Rock", "Negro", "Mediano", DevilDanger("Satan"),
            EliminationDevil(LevelDevil.Eliminar)),
        DogsCompany("Rotwailer", "Rex", "Rojo", "Grande", DevilDanger("Lucifer"),
            EliminationDevil(LevelDevil.EliminarQuemar)),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sealed_class03)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dogsList.forEach {
            when(it.dangerDog){
                is DevilDanger -> huir()
                LightDanger -> acariciar()
                MediumDanger -> apartarse()
                NoDanger -> achuchar()
                VeryDanger -> quedarseQuieto()
                is EliminationDevil -> when(it.elimination.levelDevil){
                    LevelDevil.NoEliminar -> noEliminar()
                    LevelDevil.Cuidado -> tenerCuidado()
                    LevelDevil.Cuarentena -> ponerEnCuarentena()
                    LevelDevil.Eliminar -> eliminar()
                    LevelDevil.EliminarQuemar -> eliminarYQuemar()
                    is LevelDevil.Rabioso -> mandarLaboratorio()
                }
            }
        }
    }

    private fun mandarLaboratorio() {
        TODO("Not yet implemented")
    }

    private fun eliminarYQuemar() {
        TODO("Not yet implemented")
    }

    private fun tenerCuidado() {
        TODO("Not yet implemented")
    }

    private fun eliminar() {
        TODO("Not yet implemented")
    }

    private fun ponerEnCuarentena() {
        TODO("Not yet implemented")
    }

    private fun noEliminar() {
        TODO("Not yet implemented")
    }

    private fun quedarseQuieto() {
        TODO("Not yet implemented")
    }

    private fun achuchar() {
        TODO("Not yet implemented")
    }

    private fun apartarse() {
        TODO("Not yet implemented")
    }

    private fun acariciar() {
        TODO("Not yet implemented")
    }

    private fun huir() {
        TODO("Not yet implemented")
    }
}