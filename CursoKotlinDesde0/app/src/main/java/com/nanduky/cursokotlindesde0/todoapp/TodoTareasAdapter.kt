package com.nanduky.cursokotlindesde0.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R

/* Le pasamos a la clase un segundo parámetro para el check del item */
class TodoTareasAdapter(
    var tareas: List<TodoTareas>,
    private val onTareaSeleccionada: (Int) -> Unit
) :
    RecyclerView.Adapter<TodoTareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTareasViewHolder {
        /** Creamos un inflador de vistas. El context lo extraemos del ViewGroup */
        val nuevaVista =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_tarea, parent, false)
        return TodoTareasViewHolder(nuevaVista)
    }

    override fun getItemCount() = tareas.size

    override fun onBindViewHolder(holder: TodoTareasViewHolder, position: Int) {
        holder.render(tareas[position])
        /* Llamar a la función lambda pasandole la posición cuando se haga click en el item*/
        holder.itemView.setOnClickListener{onTareaSeleccionada(position) }
    }
}