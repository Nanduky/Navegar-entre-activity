package com.nanduky.cursokotlindesde0.imccalculadora

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityImcCalculadoraBinding

class ImcCalculadoraActivity : AppCompatActivity() {

    /** Crear el binding */
    private lateinit var binding: ActivityImcCalculadoraBinding

    /** Variables para los valores iniciales de la app */
    private var pesoActual: Int = 80
    private var edadActual: Int = 30
    private var alturaActual: Int = 120

    /** Variables Booleanas para controlar que CarView (Hombre/Mujer) se ha pulsado*/
    private var selectHombre: Boolean = true
    private var selectMujer: Boolean = false

    /** Para declarar una constante para que se pueda acceder desde cualquier parte del proyecto */
    companion object {
        /** Lo que esté aquí dentro, t.o.d.o. el mundo puede acceder a ello */
        /** Para declarar una constante, hay que poner el const delante y va en letras mayúsculas */
        const val IMC_KEY = "IMC"
        /** En la Activity dónde se vaya a usar, hay que importar la */
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Inflar el binding con la vista */
        binding = ActivityImcCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_imc_calculadora)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Establecer una altura,peso y edad para que no estén las etiquetas vacías */
        "120 cm".also { binding.tvAltura.text = it } // Normal
        pesoActual.also { peso -> binding.tvPeso.text = peso.toString() } // Lambda
        // binding.tvPeso.text = "60" <== es los mismo que el also. Aquí está las dos formas de declarar
        edadActual.also { age -> binding.tvEdad.text = age.toString() } // Lambda

        /** Crear un método para llamar a los clicks de las funciones que están escuchando */
        initListeners()
        /** Función para iniciar funciones en el onCreate */
        initUI()
    }

    /** Función que escucha los listeners de los onClicks */
    private fun initListeners() {
        /** comprueba que carView ha sido pulsado */
        binding.cvHombre.setOnClickListener {// 01.- Si pulsas hombre
            /** Cambia el valor Booleano */
            cambiaGenero()
            /** Cambia el background del cardView según se pulse */
            establecerColor()
        }
        binding.cvMujer.setOnClickListener {
            /** Cambia el valor Booleano */
            cambiaGenero()
            /** Cambia el background del cardView según se pulse */
            establecerColor()
        }
        /**
         *Método para controlar el movimiento del Slider
         * El primer valor es "slider" y el tercero es "fromUser" y si no se usa,
         *  se pone barra baja "_"
         */
        binding.rsAltura.addOnChangeListener { _, value, _ ->
            /** Formatear el valor para quitar los decimales */
            val df = DecimalFormat("#.##")

            /** Guardar el valor formateado */
            alturaActual = df.format(value).toInt()
            /** Pasar el valor de "thumb" al textView */
            StringBuilder(alturaActual.toString()).append(" cm").also { binding.tvAltura.text = it }
//            binding.tvAltura.text = StringBuilder(result).append(" cm".lowercase()).toString()
        }
        /** Botón flotante para sumar peso */
        binding.fabAddPeso.setOnClickListener {
            pesoActual += 1 // Lo que en java era "pesoActual++"
            /** Método para ajustar el peso en la textView */
            colocaPeso()
        }
        /** Botón flotante para restar peso */
        binding.fabSubPeso.setOnClickListener {
            /** Resta uno */
            pesoActual -= 1
            /** Función para escribir el nuevo peso en el textView */
            colocaPeso()
        }
        /** Botón flotante para sumar edad */
        binding.fabSubEdad.setOnClickListener {
            edadActual -= 1 // Suma 1
            /** Función para escribir en el textView la nueva edad */
            colocaEdad()
        }
        /** Botón para restar edad */
        binding.fabAddEdad.setOnClickListener {
            edadActual += 1 // Resta uno
            /** Función para escribir la edad nueva en el textView */
            colocaEdad()
        }
        /** Captura el click en el botón de calcular*/
        binding.btnCalcular.setOnClickListener {
            /** Variable que recoge el resultado de la función calcularImc */
            val resultado = calcularImc()
            /** Función para navegar a otra Activity pasando le datos  */
            navegaAlResultado(resultado)
        }
    }

    private fun navegaAlResultado(resultado: Double) {
        /** Crear el intent para ir a la otra Activity */
        val intent = Intent(this, CalculadoraImcResultActivity::class.java)
        /** Meter los datos en el intent para pasarlos a la activity */
        intent.putExtra(IMC_KEY, resultado)
        /** Pasa el intent e iniciarla */
        startActivity(intent)
    }

    /** Función que calcula el IMC y retorna el valor */
    private fun calcularImc(): Double {
        /** Variable par formatear con 2 decimales */
        val df = DecimalFormat("#.##")

        /** Variable que guarda el resultado formateado */
        val imc =
            df.format(pesoActual / (alturaActual.toDouble() / 100 * alturaActual.toDouble() / 100))
                .toString().replace(',', '.')
        /** Retornar el valor a la llamada de la función */
        return imc.toDouble()
    }

    /** Función que coloca el nuevo valor del peso en el textview */
    private fun colocaPeso() {
        binding.tvPeso.text = pesoActual.toString()
    }

    /** Función que coloca el nuevo valor de la edad en el textView */
    private fun colocaEdad() {
        binding.tvEdad.text = edadActual.toString()
    }

    /** Función que cambia el valor Boleano al contrario según selección */
    private fun cambiaGenero() {
        selectHombre = !selectHombre
        selectMujer = !selectMujer
    }

    /** Función para cambiar el fondo de los CardView */
    private fun establecerColor() {
        binding.cvHombre.setCardBackgroundColor(obtenerColorFondo(selectHombre)) // 02.- llama a la función que obtiene el color y se lo devuelve
        binding.cvMujer.setCardBackgroundColor(obtenerColorFondo(selectMujer))
        /** Aquí se llama a la función "obtenerColorFondo()" y se le pasa eo boleano */
    }

    /** Función que define el color según el componente genero select */
    private fun obtenerColorFondo(componenteSelect: Boolean): Int {
        /** Variable que almacenará el color según la elección */
        val referenciaDeColor =
            if (componenteSelect) R.color.background_component_selected // 03.- Comprueba que se pulso el hombre
            else R.color.background_component

        /** Almacena y retorna el color en el formato necesarío, que en este casi es un Int */
        return ContextCompat.getColor(
            this,
            referenciaDeColor
        ) // 04.- Obtiene el color y lo retorna
    }

    /** función puesta el onCreate para iniciar las funciones y que no ocupen espacio allí */
    private fun initUI() {
        /** Función para cambiar el fondo de los CardView */
        establecerColor()
        /** Función que coloca el nuevo valor del peso en el textview */
        colocaPeso()
        /** Función que coloca el nuevo valor de la edad en el textView */
        colocaEdad()
    }

}