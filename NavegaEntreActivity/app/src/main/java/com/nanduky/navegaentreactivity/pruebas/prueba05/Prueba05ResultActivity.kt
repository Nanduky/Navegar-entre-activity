package com.nanduky.navegaentreactivity.pruebas.prueba05

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.data.Constantes
import com.nanduky.navegaentreactivity.databinding.ActivityPrueba05ResultBinding

class Prueba05ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrueba05ResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPrueba05ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_prueba05)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {

        editText(mensajeFun(obtenerValoresItems()))


    }



    private fun obtenerValoresItems(): Array<String?> {
        val nombre = intent.extras?.getString(Constantes.NOMBRE_USUARIO) ?: ""
        val apellido = intent.extras?.getString(Constantes.APELLIDO_USUARIO) ?: ""
        val rbSelected = intent.extras?.getString(Constantes.RB_SELECTED) ?: ""
        val checkSelect = intent.extras?.getStringArrayList(Constantes.CHECK_SELECTED)
        val valorArray = arrayOf(nombre, apellido, rbSelected, checkSelect?.joinToString(", "))
        return valorArray
    }

    private fun mensajeFun(obtenerValoresItems: Array<String?>): String {
        val (nombre, apellido, rbSelected, cbSelected) = obtenerValoresItems
        val textnombre = "Tu nombre es: $nombre"
        val textapellido = "\ny tu apellido: $apellido"
        val textrbSelected = "\nel radioBotton es: $rbSelected"
        val textcbSelected = "\nhas elegido los siguientes checkBox: $cbSelected"

        return StringBuilder(textnombre)
            .append(textapellido)
            .append(textrbSelected)
            .append(textcbSelected)
            .toString()
    }
    private fun editText(mensaje: String) {
        binding.tvNombre05.text = mensaje
    }
}