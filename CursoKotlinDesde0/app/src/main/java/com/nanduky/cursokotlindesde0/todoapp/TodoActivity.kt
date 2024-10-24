package com.nanduky.cursokotlindesde0.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityTodoBinding
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Negocio
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Otro
import com.nanduky.cursokotlindesde0.todoapp.TodoTareaCategorias.Personal

class TodoActivity : AppCompatActivity() {

    /** Crear el listado de categorías para el TodoCategoriasAdapter() */
    private val categorias = listOf(
        Negocio,
        Personal,
        Otro
        /** Esta es la lista que se pintará en el RecyclerView. Pinta 3 categorías, no porque sean las del
        TodoTareaCategorias, sino por que son las que se le pasan aquí, si hubiesen 10, pintaría 10 */

    )

    /** Crear el listado de categorías para el TodoTareasAdapter(). */
    /** Esta vez es una lista mutable porque iremos añadiendo datos */
    private val tareas =
        mutableListOf(
            TodoTareas("Negocios", Negocio),
            TodoTareas("Personal", Personal),
            TodoTareas("Otros", Otro)
            /** nombreTarea, categoria:TodoCategorias,  estaSeleccionado no hace falta ponerlo */
        )


    /** Crear el binding */
    private lateinit var binding: ActivityTodoBinding

    /** Crear un acceso al clase TodoCategoriasAdapter.kt */
    private lateinit var todoCategoriasAdapter: TodoCategoriasAdapter

    /** Crear un acceso al clase TodoTareasAdapter.kt */
    private lateinit var todoTareasAdapter: TodoTareasAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /** Inflar el binding con la vista */
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_todo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dialog = Dialog(this)


        /** */
        initUI()
        /** Función para iniciar todos los listeners */
        iniListeners()
    }

    private fun initUI() {
        /** Inicializar el todoCategoriasAdapter */
//        todoCategoriasAdapter =TodoCategoriasAdapter(categorias) {actualizaCategoria(it)}
        todoCategoriasAdapter =
            TodoCategoriasAdapter(categorias) { posicionIt -> actualizaCategoria(posicionIt) }
        /** Lo que le mandaremos al adapter */
        binding.rvTodoCategoria.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        /** También le pasamos el adapte */
        binding.rvTodoCategoria.adapter = todoCategoriasAdapter

        /** Inicializar el todoTareasAdapter */
        todoTareasAdapter =
            TodoTareasAdapter(tareas) { posicionIt -> onItemSeleccionado(posicionIt) }
        /** Lo que le mandaremos al adapter */
        binding.rvTodoTareas.layoutManager = LinearLayoutManager(this)
        /** Lo que el adaptado le va a poner */
        binding.rvTodoTareas.adapter = todoTareasAdapter

    }

    /** Función para iniciar los listeners */
    private fun iniListeners() {
        /** Para el botón flotante "fab"*/
        binding.fabAddTarea.setOnClickListener { mostrarDialogo() }
    }

    /** Método que se lanzará al pulsar el fab */
    private fun mostrarDialogo() {
        /** Creamos una variable*/
        val dialogo = Dialog(this)
        /** Ponemos la vista al dialogo */
        dialogo.setContentView(R.layout.dialogo_tarea)

        /** hacemos el cast a los componentes, ya que con el binding queda desformado */
        val btnAddTarea: Button = dialogo.findViewById(R.id.btn_add_tarea)  //
        val etTarea: EditText = dialogo.findViewById(R.id.et_tarea)     //
        val rgCategorias: RadioGroup = dialogo.findViewById(R.id.rg_categorias) //

        /** Captura el click del radioBroup */
        btnAddTarea.setOnClickListener { //
            /* Variable para almacenar el texto el editText*/
            val textoTareaSelect = etTarea.text.toString()
            if (textoTareaSelect.isNotEmpty()) {
                /** Guardar un una variable el id del RB (RadioButton) seleccionado */
                val selectId = rgCategorias.checkedRadioButtonId

                /** Acceder a un RB dentro del grupo y guardar el la variable el RB seleccionado*/
                val selectRadioButton: RadioButton = rgCategorias.findViewById(selectId)

                /** Comprobar que RB ha sido seleccionado a través del texto y guardar en la variable
                 * la categoría */
                val categoriaActual: TodoTareaCategorias = when (selectRadioButton.text) {
                    getString(R.string.todo_negocio) -> Negocio
                    getString(R.string.todo_personal) -> Personal
                    else -> Otro
                }
                /** Añadir la tarea a la mutableListOf de tareas*/
                tareas.add(TodoTareas(textoTareaSelect, categoriaActual))
                /** Llamamos a la función que actualiza la lista del adapter*/
                updateTarea()
                /** Tras pulsar el botón de añadir tarea,cerramos el dialogo */
                dialogo.hide()
            } else {
                Toast.makeText(this, "Ingresa la tarea primero", Toast.LENGTH_SHORT).show()
            }
        }
        /** Llamar al dialogo */
        dialogo.show()
    }

    /** Para modificar los items de las tareas, se crea una función que recibirá una posición (Int) */
    private fun onItemSeleccionado(posicion: Int) {
        /** cambiar de seleccionado a no seleccionado a través del Boolean del TodoTareas*/
        tareas[posicion].estaSelect = !tareas[posicion].estaSelect
        /** Notifecar al adapter que hanhabido cambios */
        updateTarea()
    }

    /** Función para cambiar la selección del item */
    private fun actualizaCategoria(posicion: Int) {
        /** pon lo opuesto de lo que había */
        categorias[posicion].estaSeleccionado = !categorias[posicion].estaSeleccionado
        /** Actualizar el item seleccionado */
        todoCategoriasAdapter.notifyItemChanged(posicion)
        /** Llamar al updateTarea */
        updateTarea()
    }

    /** Función para actualizar la lista que tiene el adapter*/
    private fun updateTarea() {
        /** Variable para guardar las categorías seleccionadas*/
        val categoriasSelected : List<TodoTareaCategorias> = categorias.filter { it.estaSeleccionado }
        /** Variable guardará las tareas que tengan las categorías seleccionadas */
        val nuevasTareas = tareas.filter { categoriasSelected.contains(it.categorias) }
        /* Le pasamos al adapte las tareas que tiene que pintar y no toda la lista */
        todoTareasAdapter.tareas = nuevasTareas
        todoTareasAdapter.notifyDataSetChanged()
    }
}