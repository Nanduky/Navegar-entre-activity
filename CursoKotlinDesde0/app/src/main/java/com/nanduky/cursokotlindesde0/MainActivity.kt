package com.nanduky.cursokotlindesde0

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.ajustesapp.AjustesActivity
import com.nanduky.cursokotlindesde0.consumodeapi.DogListActivity
import com.nanduky.cursokotlindesde0.databinding.ActivityMainBinding
import com.nanduky.cursokotlindesde0.ejemplos.SealedClassActivity
import com.nanduky.cursokotlindesde0.imccalculadora.ImcCalculadoraActivity
import com.nanduky.cursokotlindesde0.primera_app.PrimeraAppActivity
import com.nanduky.cursokotlindesde0.superheroapp.SuperHeroListActivity
import com.nanduky.cursokotlindesde0.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //<= varirante que hará de conductor de vistas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //<= nuevo inflater
        setContentView(binding.root) // <= acceso al layaut
        /**
         *  Ahora para acceder a cualquier vista del layout hay que llamarla desde el binding
         * bindin.btn1.setOnClickListener{...}
         * */
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main) <= no lo cargamos
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /** Para ir a la PrimeraAppActivity */
        binding.btnPrimeraApp.setOnClickListener { irPrimeraApp() }
        /** Para ir a la ImcCalculadoraActivity */
        binding.btnIMCApp.setOnClickListener { irImcApp() }
        /** Para ir a la SealedClassActivity */
        binding.btnSealedClas.setOnClickListener { irSealedClassApp() }
        /** Para ir a la TodoActivity*/
        binding.btnTodo.setOnClickListener { irTodoApp() }
        /** Para ir a la DogListActivity */
        binding.btnDogList.setOnClickListener { irDogListApp() }
        /** Para ir a la SuperHeroListActivity */
        binding.btnSuper.setOnClickListener { irSuperHeroListApp() }
        /** Para ir a la AjustesActivity */
        binding.btnAjustes.setOnClickListener { irAjusteApp() }
    }


    private fun irPrimeraApp() {
        val primeraAppIntent = Intent(this, PrimeraAppActivity::class.java)
        startActivity(primeraAppIntent)
    }

    private fun irImcApp() {
        val imcAppIntent = Intent(this, ImcCalculadoraActivity::class.java)
        startActivity(imcAppIntent)
    }

    private fun irSealedClassApp(){
        val sealedClassIntent = Intent(this, SealedClassActivity::class.java)
        startActivity(sealedClassIntent)
    }

    private fun irTodoApp(){
        val todoActivityAppIntent = Intent(this, TodoActivity::class.java)
        startActivity(todoActivityAppIntent)
    }

    private fun irDogListApp() {
        val dogListAppIntent = Intent(this, DogListActivity::class.java)
        startActivity(dogListAppIntent)
    }

    private fun irSuperHeroListApp(){
        val superHeroListApp = Intent(this, SuperHeroListActivity::class.java)
        startActivity(superHeroListApp)
    }

    private fun irAjusteApp(){
        val ajustesActivityIntent = Intent(this, AjustesActivity::class.java)
        startActivity(ajustesActivityIntent)
    }
}