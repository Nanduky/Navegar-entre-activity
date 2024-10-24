package com.nanduky.cursokotlindesde0.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ItemTodoTareaBinding
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Negocio
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Otro
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Personal

class TodoTareasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /** Creamos el binding */
    private val binding = ItemTodoTareaBinding.bind(view)

    fun render(tarea: TodoTareas) {

        /* Variable para recoger el binding y no tener que ponerlo toto el rato */
        val tvTodoTarea = binding.tvTodoTarea
        val cbTodoTarea = binding.cbTodoTarea

        /* Hacer que se tache el nombre al hacer click */
        if (tarea.estaSelect) {
            tvTodoTarea.paintFlags = tvTodoTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else { // Para que se destache
            tvTodoTarea.paintFlags = tvTodoTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        /** Para poner el nombre de la tarea */
        tvTodoTarea.text = tarea.nombreTarea
        /** Para marcar el checkBox aunque pulse fuera, en otra parte del item */
        cbTodoTarea.isChecked = tarea.estaSelect
        /* Para pintar un color en el checkBox */
        val colorTarea = when (tarea.categorias) {
            Negocio -> R.color.todo_trabajo_categoria
            Otro -> R.color.todo_otros_categoria
            Personal -> R.color.todo_personal_categoria
        }
        cbTodoTarea.buttonTintList =
            ColorStateList.valueOf(ContextCompat.getColor(cbTodoTarea.context, colorTarea))
    }

}