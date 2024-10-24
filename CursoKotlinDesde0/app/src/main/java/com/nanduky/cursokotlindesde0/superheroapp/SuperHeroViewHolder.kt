package com.nanduky.cursokotlindesde0.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /** Crear el binding para el recyclerView */
    private val bindigSHVH = ItemSuperheroBinding.bind(view)

    /** Función que va a recibir uno de los items de SuperHeroItemDataClassResponse*/
    fun bindSHVH(
        superHeroItemDataClassResponse: SuperHeroItemDataClassResponse,
        onItemSeleccionado: (String) -> Unit
    ) {
        /** pasarle el nombre */
        bindigSHVH.tvSuperNombre.text = superHeroItemDataClassResponse.superHeroNombre
        /** Pasar la url de "image" a través de Picasso */
        Picasso.get().load(superHeroItemDataClassResponse.superHeroImage.urlImage)
            .into(bindigSHVH.ivSuperImage)
        /** Capturar el click en cualquier parte de la vista */
        bindigSHVH.root.setOnClickListener {
            onItemSeleccionado(superHeroItemDataClassResponse.superHeroId)

        }
    }
}