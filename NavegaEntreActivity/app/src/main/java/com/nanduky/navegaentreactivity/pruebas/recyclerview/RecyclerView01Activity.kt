package com.nanduky.navegaentreactivity.pruebas.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.databinding.ActivityRecyclerView01Binding
import com.nanduky.navegaentreactivity.pruebas.recyclerview.adapter.CarsAdapter

class RecyclerView01Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerView01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerView01Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyleview01.layoutManager = LinearLayoutManager(this)
        binding.recyleview01.adapter = CarsAdapter(CarsProvaider.carList)
    }
}