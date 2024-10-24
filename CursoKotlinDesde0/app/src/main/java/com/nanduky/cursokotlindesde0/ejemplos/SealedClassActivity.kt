package com.nanduky.cursokotlindesde0.ejemplos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivitySealedClassBinding
import com.nanduky.cursokotlindesde0.ejemplos.GameError.CongeladoError
import com.nanduky.cursokotlindesde0.ejemplos.GameError.InternetError
import com.nanduky.cursokotlindesde0.ejemplos.GameError.NoError
import com.nanduky.cursokotlindesde0.ejemplos.GameError.RayadoError
import com.nanduky.cursokotlindesde0.ejemplos.GameError.VersionError

class SealedClassActivity : AppCompatActivity() {

    /** Crear el binding */
    private lateinit var binding: ActivitySealedClassBinding

    /** Creamos una variable con el listado de juegos, con el titulo, nº de serie y el posible error */
    val listaJuegos = listOf<GameModel>(
        GameModel("Mario", "0123456789", InternetError),
        GameModel("Mario 2", "9876543210", RayadoError),
        GameModel("Mario 3", "1478523690", NoError),
        /** Si creamos un objeto error del tipo VersionError, le tendremos que pasar el parámetro que pide */
        GameModel("Mario 4", "3658452257", VersionError("1.2.0")),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /** Inflar el binding con la vista */
        binding = ActivitySealedClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_sealed_class)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Recorremos el listado de juegos y por cada error encontrado haremos algo */
        listaJuegos.forEach { modeloJuego ->
            when (modeloJuego.error) {
                InternetError -> llamarAlSoporteTecnico()
                NoError -> vender()
                RayadoError -> eliminarJuego()
                CongeladoError -> revisar() // <-- Se puede cambiar por else, pero no es recomendado
                is VersionError -> consultarVersion(modeloJuego.error.version)  // Al ser un data class hay que poner el "is" delante
            }
        }
    }

    fun llamarAlSoporteTecnico() {

    }

    fun eliminarJuego() {

    }

    fun vender() {

    }

    fun revisar() {

    }

    fun consultarVersion(version: String) {

    }
}