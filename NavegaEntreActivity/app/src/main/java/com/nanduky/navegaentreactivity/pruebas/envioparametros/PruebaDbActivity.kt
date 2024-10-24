package com.nanduky.navegaentreactivity.pruebas.envioparametros

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.data.Constantes.Companion.CHECK_SELECTED
import com.nanduky.navegaentreactivity.data.Constantes.Companion.PLATO
import com.nanduky.navegaentreactivity.data.Constantes.Companion.PORQUE
import com.nanduky.navegaentreactivity.data.Constantes.Companion.RB_SELECTED
import com.nanduky.navegaentreactivity.databinding.ActivityPruebaDbBinding

class PruebaDbActivity : AppCompatActivity() {

    // Crear el binding.
    private lateinit var binding: ActivityPruebaDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inflar el binding
        binding = ActivityPruebaDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_prueba_bd)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Iniciar el UI
        initUI()
    }

    //Función UI
    private fun initUI() {
        // Funcion para obtener los valores de los items
        valoresItems()
    }

    // Función para obtener los valores de los items
    private fun valoresItems() {
        // Valores de los campos
        val textPlato = intent.extras?.getString(PLATO) ?: PLATO
        val textPostre = intent.extras?.getString(RB_SELECTED) ?: RB_SELECTED
        val textPorQue = intent.extras?.getString(PORQUE) ?: PORQUE
        val arraySetectPostres = intent.extras?.getStringArrayList(CHECK_SELECTED)
        val textSetectPostres = arraySetectPostres?.joinToString(", ") ?: CHECK_SELECTED

        // Llamar a la función mensaje y meterla en una variable
        val mensaje = mensaje(textPlato, textPorQue, textPostre, textSetectPostres)
        // Llamar a la función que pintará el mensaje en la pantalla
        editText(mensaje)
    }

    //Función que rellenará el textView
    private fun editText(mensaje: String) {
        // El texto a mostrar
        binding.viewResultDb.text = mensaje
    }


    // Función que crea el mensaje que se pintará en pantalla
    private fun mensaje(
        plato: String,
        porque: String,
        postre: String,
        selectPostre: String
    ): String {
        // Variables con los textos de cada campo
        val textPlato = "Tu plato favorito es: $plato"
        val textPorQue = "\ny ¿Por que te gusta?: $porque"
         val textPostre = "\nlos postres te gusta: $postre"
        val textSetectPostres = "\nhas elegido los siguientes postres: $selectPostre"
        //Mensaje
        return StringBuilder(textPlato)
            .append(textPorQue)
            .append(textPostre)
            .append(textSetectPostres)
            .toString()

    }
}