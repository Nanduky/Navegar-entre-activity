package com.nanduky.cursokotlindesde0.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R

class SuperHeroAdapter(
    var superHeroListAdapter: List<SuperHeroItemDataClassResponse> = emptyList(),
    private val onItemSeleccionado: (String) -> Unit // Función Lambda
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun actualizaListaSHA(superHeroListAdapter: List<SuperHeroItemDataClassResponse>) {
        /** el "this" es para referirse al valor de la clase y sil el al de la función */
        this.superHeroListAdapter = superHeroListAdapter
        /* Actualiza el adapte*/
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        /** Variable para inflar la vista y pasarlo alViewHolder*/
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(holderSHA: SuperHeroViewHolder, position: Int) {
        /** Creamos un Item llamado al superheroelist y la posicón que le toque */
        //val itemSHA = superHeroListAdapter[position]
        /** lo mandamos a la funcion bindSHVH del ViewHolder */
        //holderSHA.bindSHVH(itemSHA)
        /** O lo optimizamos quitando la variable */
        holderSHA.bindSHVH(superHeroListAdapter[position],onItemSeleccionado) //Enviamos lambda
    }

    /** Le pasamos el tamaño de la lista */
    override fun getItemCount() = superHeroListAdapter.size
}