package com.nanduky.mydiffutilsexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter(
    private var list: List<Superhero> ,
    private val onItemRemove: (Superhero) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {
    
    fun updatelist(newList: List<Superhero>) {
        val superheroDiff = SuperheroDiffUtil(list , newList)
        val result = DiffUtil.calculateDiff(superheroDiff)
        list = newList
        result.dispatchUpdatesTo(this)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero , parent , false)
        )
        
    }
    
    override fun getItemCount() = list.size
    
    override fun onBindViewHolder(holder: SuperheroViewHolder , position: Int) {
        holder.render(list[position] , onItemRemove)
    }
}

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    
    val tvName = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val tvId = view.findViewById<TextView>(R.id.tvId)
    
    fun render(superhero: Superhero , onItemRemove: (Superhero) -> Unit) {
        tvName.text = superhero.name
        tvId.text = superhero.id
        tvName.setOnClickListener { onItemRemove(superhero) }
    }
}