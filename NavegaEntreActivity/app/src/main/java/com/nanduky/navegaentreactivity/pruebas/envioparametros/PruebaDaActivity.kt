package com.nanduky.navegaentreactivity.pruebas.envioparametros

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.data.Constantes
import com.nanduky.navegaentreactivity.databinding.ActivityPruebaDaBinding

class PruebaDaActivity : AppCompatActivity() {

    // Crear el binding
    private lateinit var binding: ActivityPruebaDaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Inflar el binding y parsable al setContentView
        binding = ActivityPruebaDaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_prueba_da)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Iniciar UI
        initUI()
    }

    // función UI     ***No se que significa***
    private fun initUI() {
        // Llamar a la función Listener
        capturaListener()
    }

    //
    private fun capturaListener() {
        // Captura del onClick del botón enviar
        binding.btnEnviarDa.setOnClickListener { obtenerValores() }
    }

    /* Función para obtener los valores de los campos */
    private fun obtenerValores() {
        // Guardar valores de los campos
        val plato = binding.etGetPlatoDa.text.toString()
        val porque = binding.etGetPorqueDa.text.toString()
        // Para el radiobutton primero hay que extraer la id del seleccionado que es un Int
        val selectId = binding.rgPostreDa.checkedRadioButtonId
        // Pasar la id del botón seleccionado
        val rgPostreDa: RadioButton = binding.rgPostreDa.findViewById(selectId)

        // Comprobar cúal se seleccionó y meter el texto en una variable
        val rbSelect = when (rgPostreDa.text) {
            getString(R.string.siempre) -> getString(R.string.siempre)
            getString(R.string.nunca) -> getString(R.string.nunca)
            getString(R.string.aveces) -> getString(R.string.aveces)
            else -> getString(R.string.casi)
        }
        // Crear una lista para mandar por el item
        val checksSelect = ArrayList<String>()
        // Meter en una variable los items de la vista.
        val layoutItems = binding.llOpcionesDa
        // Recorrer los items por su índice
        for (i in 0 until layoutItems.childCount) {
            // Obtener el id del item
            val childItem = layoutItems.getChildAt(i)
            // Comprobar si el item es un checkbox y está checked
            if ((childItem is CheckBox) && childItem.isChecked) {
                // Guardar el texto del item en la lista de seleccionados
                checksSelect.add(childItem.text.toString())
            }
        }
        // Llamar a la función para ir a la otra activity y pasarle los datos
        navetateToPruebaBd(plato, porque, rbSelect, checksSelect)
    }


    /* Función para ir al la otra activity */
    private fun navetateToPruebaBd(
        plato: String,
        porque: String,
        rbSelect: String,
        checksSelect: ArrayList<String>
    ) {
        // Crear el intent
        val intent = Intent(this, PruebaDbActivity::class.java)
        // Pasar los datos
        intent.putExtra(Constantes.PLATO, plato)
        intent.putExtra(Constantes.PORQUE, porque)
        intent.putExtra(Constantes.RB_SELECTED, rbSelect)
        intent.putStringArrayListExtra(Constantes.CHECK_SELECTED, checksSelect)
        // Iniciar la otra Activity
        startActivity(intent)
    }
}