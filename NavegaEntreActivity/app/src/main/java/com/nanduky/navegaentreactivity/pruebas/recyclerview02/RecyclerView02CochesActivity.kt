package com.nanduky.navegaentreactivity.pruebas.recyclerview02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.pruebas.recyclerview02.adapter.Coches2Adapter
import com.nanduky.navegaentreactivity.pruebas.recyclerview02.clases.Coches2ProveedorC

class RecyclerView02CochesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view02_coches)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvCoches2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Coches2Adapter(Coches2ProveedorC.cocches2List)
    }
}