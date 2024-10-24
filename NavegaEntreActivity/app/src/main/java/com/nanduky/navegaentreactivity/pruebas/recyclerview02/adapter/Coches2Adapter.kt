package com.nanduky.navegaentreactivity.pruebas.recyclerview02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.navegaentreactivity.R
import com.nanduky.navegaentreactivity.pruebas.recyclerview02.clases.Coches2DC

class Coches2Adapter(private val coches2Lista:List<Coches2DC>):RecyclerView.Adapter<Coches2ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Coches2ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Coches2ViewHolder(layoutInflater.inflate(R.layout.item_coche2,parent,false))
    }

    override fun onBindViewHolder(holder: Coches2ViewHolder, position: Int) {
        val item = coches2Lista[position]
        holder.render(item)
    }

    override fun getItemCount()= coches2Lista.size


}