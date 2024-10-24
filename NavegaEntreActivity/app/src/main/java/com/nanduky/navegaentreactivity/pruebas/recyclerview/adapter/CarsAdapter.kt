package com.nanduky.navegaentreactivity.pruebas.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.pruebas.recyclerview.CarsDC

class CarsAdapter(private val carList: List<CarsDC>) : RecyclerView.Adapter<CarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarsViewHolder(layoutInflater.inflate(R.layout.item_cars, parent, false))
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val item = carList[position]
        holder.render(item)
    }

    override fun getItemCount() = carList.size

}