package com.nanduky.cursokotlindesde0.consumodeapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(viewVH: View) : RecyclerView.ViewHolder(viewVH) {

    private var bindingVH = ItemDogBinding.bind(viewVH)

    fun bind_dogVH(imagenDogVH: String) {
        Picasso.get().load(imagenDogVH).into(bindingVH.ivDog)
    }
}