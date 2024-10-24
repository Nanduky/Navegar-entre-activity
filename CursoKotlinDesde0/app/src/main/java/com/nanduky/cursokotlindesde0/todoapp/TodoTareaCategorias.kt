package com.nanduky.cursokotlindesde0.todoapp

sealed class TodoTareaCategorias(var estaSeleccionado: Boolean = true) {
    object Personal : TodoTareaCategorias()
    object Negocio : TodoTareaCategorias()
    object Otro : TodoTareaCategorias()
}