package com.nanduky.navegaentreactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.navegaentreactivity.databinding.ActivityMainBinding
import com.nanduky.navegaentreactivity.pruebas.envioparametros.PruebaDaActivity
import com.nanduky.navegaentreactivity.pruebas.prueba05.Prueba05Activity
import com.nanduky.navegaentreactivity.pruebas.recyclerview.RecyclerView01Activity
import com.nanduky.navegaentreactivity.pruebas.recyclerview02.RecyclerView02CochesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        initListener()
    }

    private fun initListener() {
        binding.btn04.setOnClickListener { navigateToPruebaDa() }
        binding.btnEnvioParametros.setOnClickListener { navigateToEnvioParametros() }
        binding.btnRecyclerview.setOnClickListener { navigateToRecyclerView() }
        binding.btnRecyclerview2.setOnClickListener { navigateToRecyclerView2() }
    }

    private fun navigateToPruebaDa() {
        val intent = Intent(this, PruebaDaActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToEnvioParametros() {
        val intent = Intent(this, Prueba05Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToRecyclerView(){
        val intent = Intent(this, RecyclerView01Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToRecyclerView2() {
        val intent = Intent(this, RecyclerView02CochesActivity::class.java)
        startActivity(intent)
    }
}