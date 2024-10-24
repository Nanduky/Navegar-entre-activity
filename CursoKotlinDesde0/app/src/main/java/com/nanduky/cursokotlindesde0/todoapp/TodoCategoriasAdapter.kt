package com.nanduky.cursokotlindesde0.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R

class TodoCategoriasAdapter(
    private val categoria: List<TodoTareaCategorias>,
    private val onCategoriaSeleccionada: (Int) -> Unit
) :
    RecyclerView.Adapter<TodoCategoriasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoCategoriasViewHolder {
        /** Creamos un inflador de vistas. El context lo extraemos del ViewGroup */
        val nuevaView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo_tarea_categorias, parent, false)
        return TodoCategoriasViewHolder(nuevaView)
        /*.inflate(R.layout.item_todo_tarea_categorias, parent, false)
    return TodoCategoriasViewHolder(nuevaView) */
    }

    override fun onBindViewHolder(holder: TodoCategoriasViewHolder, position: Int) {
        /**
         * Esta función nos pide una tareaCategorias y tenemos la List categoría,
         * y para saber cual hay que pasarle, tenemos la "position". También le pasamos la función lambda
         * para que la mande al render
         **/
        holder.render(categoria[position], onCategoriaSeleccionada)
    }

    override fun getItemCount() = categoria.size
}
