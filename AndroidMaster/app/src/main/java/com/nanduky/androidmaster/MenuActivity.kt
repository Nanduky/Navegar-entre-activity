package com.nanduky.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.androidmaster.firsapp.FirstAppActivity
import com.nanduky.androidmaster.imccalculator.ImcCalculatorActivity
import com.nanduky.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        btnSaludApp.setOnClickListener { navigateToSaludApp()}
        btnIMCApp.setOnClickListener { navigateIMCApp()}
        btnTODO.setOnClickListener { navigateApp() }
    }

    private fun navigateApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}