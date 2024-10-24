package com.nanduky.permisionscontrolactivity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)
        btnPhoto.setOnClickListener { checkPermission() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            //Permiso no aceptado por el momento
            recuestCameraPermission()
        } else {
            openCamera()
        }
    }

    private fun openCamera() {
        Toast.makeText(this, "Abriendo cámara", Toast.LENGTH_SHORT).show()
    }

    private fun recuestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            // El usuario ya ha rechazado los permisos
            Toast.makeText(this,"Permisos rechazados", Toast.LENGTH_SHORT).show()

        } else {
            // Pedir permisos
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 777)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 777) { // nuestros permisos
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(this,"Permisos rechazados por primera vez", Toast.LENGTH_SHORT).show()
            }
        }
    }
}