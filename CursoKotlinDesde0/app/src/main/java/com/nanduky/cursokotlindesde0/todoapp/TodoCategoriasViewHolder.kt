package com.nanduky.cursokotlindesde0.todoapp

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ItemTodoTareaCategoriasBinding
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Negocio
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Otro
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Personal

class TodoCategoriasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /** creamos el binding */
    private val binding = ItemTodoTareaCategoriasBinding.bind(view)

    /** Esta función recibe una tareaCategoría y una función lambda*/
    fun render(tareaCategorias: TodoTareaCategorias, onCategoriaSeleccionada: (Int) -> Unit) {
        /** Crear variables para los componentes del binding */
        val tvNombreCategoria = binding.tvNombreCategoria
        val lineaDivisoria = binding.lineaDivisoria
        val contenedoVista = binding.contenedorVista

        /** Comprobamos que categoría a sido seleccionada  */
        val colorSeleccion = if (tareaCategorias.estaSeleccionado) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        /** Añadimos el color a la CardView seleccionada*/
        contenedoVista.setCardBackgroundColor(
            ContextCompat.getColor(
                contenedoVista.context,
                colorSeleccion
            )
        )

        /** Capturar el click del item seleccionado*/
        itemView.setOnClickListener { onCategoriaSeleccionada(layoutPosition) }

        /** Se crea dos when que recorran las categorías de la sealed class*/

        /** Variable que guardará el nombre de la categoría*/
        val nombreCategorias = when (tareaCategorias) {
            Negocio -> R.string.todo_negocio
            Otro -> R.string.todo_otros
            Personal -> R.string.todo_personal
        }
        /** Pasar al item el nombre de la categoría guardado en la variable */
        tvNombreCategoria.text = tvNombreCategoria.context.getString(nombreCategorias)

        /** Variable que guardará el color de la linea divisoría */
        val colorDivisor = when (tareaCategorias) {
            Negocio -> R.color.todo_trabajo_categoria
            Otro -> R.color.todo_otros_categoria
            Personal -> R.color.todo_personal_categoria
        }
        /** Pasar el color al item guardado en la variable */
        lineaDivisoria.setBackgroundColor(
            ContextCompat.getColor(
                lineaDivisoria.context,
                colorDivisor
            )
        )
    }
}