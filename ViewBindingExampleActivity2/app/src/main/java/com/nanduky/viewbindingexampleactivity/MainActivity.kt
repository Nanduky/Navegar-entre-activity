package com.nanduky.viewbindingexampleactivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.viewbindingexampleactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var vincular: ActivityMainBinding

    private val miLista = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vincular = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vincular.root)
        vincular.btnMostrarFragment.setOnClickListener { abrirFragment() }
        vincular.btnMostrarRv.setOnClickListener { mostrarRecyclerView() }
    }

    private fun mostrarRecyclerView() {
        vincular.fragmentContenedor.visibility = View.GONE
        vincular.rvLista.visibility = View.VISIBLE

        vincular.rvLista.setHasFixedSize(true)
        vincular.rvLista.layoutManager = LinearLayoutManager(this)
        val adaptador = MiAdaptador(miLista)
        vincular.rvLista.adapter = adaptador
    }

    private fun abrirFragment() {
        vincular.fragmentContenedor.visibility = View.VISIBLE
        vincular.rvLista.visibility = View.GONE

        val fragmentTransaccion = supportFragmentManager.beginTransaction()
        fragmentTransaccion.add(R.id.fragment_contenedor, EjemploFragment())
        fragmentTransaccion.commit()
    }
}