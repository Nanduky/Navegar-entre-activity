package com.nanduky.viewbindingexampleactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.viewbindingexampleactivity.databinding.ItemSuperheroListBinding


class MyAdapter(private val list: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: String = list[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero_list, parent, false))
    }

    override fun getItemCount() = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val tvSuperhero = view.findViewById<TextView>(R.id.tvSuperHero)
        private val binding = ItemSuperheroListBinding.bind(view)

        fun bind(superhero: String) {
            binding.tvSuperHero.text = superhero

        }
    }
}