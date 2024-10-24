package com.nanduky.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.recyclerviewexample.R
import com.nanduky.recyclerviewexample.SuperHero

class SuperHeroAdapter(private val superheroList: List<SuperHero>, private val onClickListener:(SuperHero) -> Unit) : RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero,parent,false)
        return SuperHeroViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = (superheroList[position])
        holder.render(item, onClickListener)

//        holder.render(superHeroList[position]) <-- es lo mismo resumido
    }

    override fun getItemCount(): Int = superheroList.size
}