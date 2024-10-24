package com.nanduky.navegaentreactivity.pruebas.recyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanduky.navegaentreactivity.databinding.ItemCarsBinding
import com.nanduky.navegaentreactivity.pruebas.recyclerview.CarsDC

class CarsViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemCarsBinding.bind(view)
    fun render(carsDC: CarsDC){
        binding.tvMarca.text = carsDC.markCar
        binding.tvModelo.text = carsDC.modelCar
        binding.tvFuel.text = carsDC.fuelCar
        binding.tvColor.text = carsDC.colorCar
        Glide.with(binding.ivCar.context).load(carsDC.photo).into(binding.ivCar)
    }
}