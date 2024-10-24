package com.nanduky.cursokotlindesde0.primera_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityPrimeraAppBinding

class PrimeraAppActivity : AppCompatActivity() {

    /** Crear la variable para el binding */
    private lateinit var binding: ActivityPrimeraAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Inflamos la vista y se la pasamos al setContentView */
        binding = ActivityPrimeraAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_primera_app)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        funOnClick()
        /** Llamar a la función que controla los click de los botones */
    }

    /** Función que controla los clicks de los botones */
    private fun funOnClick() {
        binding.btnPulsaMe.setOnClickListener {
            /** Variable con el texto del textView */
            val etNombre: String = binding.etNombre.text.toString()
            /** Comprobar que el campo no está vacío */
            if (etNombre.isEmpty()) {
                Toast.makeText(this, "Introduce tu nombre", Toast.LENGTH_LONG)
                    .show()
            } else {
                funIntent(etNombre)
            }
        }
    }

    /** Función para navegar entre activity's */
    private fun funIntent(nombre: String) {
        /** Crear un intent y pasarle la dirección donde hay que ir */
        val intentResultadoActivity = Intent(this, ResultadoActivity::class.java)
        /** Enviar un dato al al activity que vamos a inicializar y ponerle un nombre al extra */
        intentResultadoActivity.putExtra("NOMBRE", nombre)
        /** Iniciar la activity a la que se llama */
        startActivity(intentResultadoActivity)
    }

}