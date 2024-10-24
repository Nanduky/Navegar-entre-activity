package com.nanduky.navegaentreactivity.pruebas.recyclerview02.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.databinding.ItemCoche2Binding
import com.nanduky.navegaentreactivity.pruebas.recyclerview02.clases.Coches2DC

class Coches2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCoche2Binding.bind(view)
    fun render(coches2DC: Coches2DC) {
        val marcaModelo =
            StringBuilder(coches2DC.marcaCoche2DC).append("-").append(coches2DC.modeloCoche2DC)
        binding.tvMarcaModelo.text = marcaModelo
        binding.tvPrecio2.text = coches2DC.precioCoche2DC
        val yearFuellKm =
            StringBuilder(coches2DC.yearCoche2DC).append("-").append(coches2DC.fuelCoche2DC)
                .append("-").append(coches2DC.kmsCoche2DC)
        binding.tvDesciption.text = yearFuellKm
        binding.tvCambio.text = coches2DC.cambioCoche2DC
        Glide.with(binding.ivCoches.context).load(coches2DC.fotoCoche2DC).into(binding.ivCoches)
        binding.ivCoches.setBackgroundResource(R.color.gris_coche)
        val col = binding.ivCoches
        when(coches2DC.colorCoche2DC){
            "rojo"-> col.setBackgroundResource(R.color.rojo_coche)
            "negro"-> col.setBackgroundResource(R.color.negro_coche)
            "gris"-> col.setBackgroundResource(R.color.gris_coche)
            "azul"-> col.setBackgroundResource(R.color.azul_coche)
            "amarillo"-> col.setBackgroundResource(R.color.amarillo_coche)
            "verde"-> col.setBackgroundResource(R.color.verde_coche)
            else -> col.setBackgroundColor(Color.TRANSPARENT)
        }
    }
}