package com.nanduky.recyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.recyclerviewexample.adapter.SuperHeroAdapter
import com.nanduky.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        initRecycleView()
    }

    private fun initRecycleView() {
        val manager = GridLayoutManager(this, 1)
        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter =
            SuperHeroAdapter(SupeHeroProvider.superheroList) { superHero ->
                onItemSeleted(
                    superHero
                )
            }
    }

    fun onItemSeleted(superHero: SuperHero) {
        Toast.makeText(this, superHero.superhero, Toast.LENGTH_SHORT).show()
    }
}