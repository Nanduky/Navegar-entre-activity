package com.nanduky.cursokotlindesde0.primera_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    /** Crear la variable para el binding */
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Crear el binding e inflarlo y pasarlo al context*/
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_resultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Si existe un valor con esat "key" dame lo, sino, dame lo vacío */
        val nombre: String = intent.extras?.getString("NOMBRE").orEmpty()
        /** Enviar el dato recogido a el TextView */
        //binding.tvResultado.text = "Hola $nombre"
        //"Hola $nombre".also { binding.tvResultado.text = it }
        "Hola $nombre".also { valor -> binding.tvResultado.text = valor }
    }
}