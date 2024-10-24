package com.nanduky.mydiffutilsexample

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    
    private var superheroes = listOf(
        Superhero("AristiDevs" , "1" , "cursokotlin.com") ,
        Superhero("KotlinMan" , "2" , "cursokotlin.com") ,
        Superhero("FlutterCry" , "3" , "cursokotlin.com")
    
    )
    
    lateinit var superheroAdapter: SuperheroAdapter
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v , insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left , systemBars.top , systemBars.right , systemBars.bottom)
            insets
        }
        val btnAddSuperHero = findViewById<Button>(R.id.btnAddSuperHero)
        val rv = findViewById<RecyclerView>(R.id.rvExample)
        btnAddSuperHero.setOnClickListener {
            val random = Random.nextInt(10000).toString()
            val superhero = Superhero("FlutterCry $random" , random , "cursokotlin.com")
            superheroes = superheroes.plus(superhero)
            superheroAdapter.updatelist(superheroes)
//            superheroAdapter.notifyDataSetChanged()
        }
        superheroAdapter = SuperheroAdapter(superheroes) {
//            superheroes.remove(it)
            superheroes = superheroes.minus(it)
            superheroAdapter.updatelist(superheroes)
//            superheroAdapter.notifyDataSetChanged()
        }
        
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = superheroAdapter
        }
    }
}