package com.nanduky.cursokotlindesde0.consumodeapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R

class DogAdapter(private val imagenesDogsAdap: List<String>) : RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parentAdap: ViewGroup, viewTypeAdap: Int): DogViewHolder {
        val layoutInflaterAdap=LayoutInflater.from(parentAdap.context)
        return DogViewHolder(layoutInflaterAdap.inflate(R.layout.item_dog,parentAdap,false))
    }

    override fun getItemCount() = imagenesDogsAdap.size


    override fun onBindViewHolder(holderAdap: DogViewHolder, positionAdap: Int) {
        val itemAdap:String = imagenesDogsAdap[positionAdap]
        holderAdap.bind_dogVH(itemAdap)
    }
}