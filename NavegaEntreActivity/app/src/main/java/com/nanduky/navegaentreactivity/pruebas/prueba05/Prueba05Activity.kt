package com.nanduky.navegaentreactivity.pruebas.prueba05

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
import com.nanduky.navegaentreactivity.databinding.ActivityPrueba05Binding

class Prueba05Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPrueba05Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPrueba05Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_prueba05)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        capturalistener()
    }

    private fun capturalistener() {
        binding.btnEnviar05.setOnClickListener { obtenerDatos() }
    }

    private fun obtenerDatos() {
        val nombre = binding.etGetNombre05.text.toString()
        val apellido = binding.etGetApellido05.text.toString()
        val selectId = binding.rgPrueba05.checkedRadioButtonId
        val rbOpciones: RadioButton = findViewById(selectId)
        val rbSelected = when (rbOpciones.text) {
            getString(R.string.rb_op01) -> getString(R.string.rb_op01)
            getString(R.string.rb_op02) -> getString(R.string.rb_op02)
            else -> getString(R.string.rb_op03)
        }
        val checkSelected = ArrayList<String>()
        val layoutItems = binding.layoutOption05
        for (i in 0 until layoutItems.childCount) {
            val child = layoutItems.getChildAt(i)
            if ((child is CheckBox) && child.isChecked) checkSelected.add(child.text.toString())
        }
        navigateToResultActivity(nombre, apellido, rbSelected, checkSelected)
    }

    private fun navigateToResultActivity(
        nombre: String,
        apellido: String,
        rbSelected: String,
        checkSelected: java.util.ArrayList<String>
    ) {
        val intent = Intent(this, Prueba05ResultActivity::class.java)
        intent.putExtra(Constantes.NOMBRE_USUARIO, nombre)
        intent.putExtra(Constantes.APELLIDO_USUARIO, apellido)
        intent.putExtra(Constantes.RB_SELECTED, rbSelected)
        intent.putStringArrayListExtra(Constantes.CHECK_SELECTED, checkSelected)
        startActivity(intent)
    }
}