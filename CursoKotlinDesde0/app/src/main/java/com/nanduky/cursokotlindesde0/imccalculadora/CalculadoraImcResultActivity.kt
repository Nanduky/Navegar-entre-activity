package com.nanduky.cursokotlindesde0.imccalculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityCalculadoraImcResultBinding
import com.nanduky.cursokotlindesde0.imccalculadora.ImcCalculadoraActivity.Companion.IMC_KEY

class CalculadoraImcResultActivity : AppCompatActivity() {

    /** Crear la variable binding */
    private lateinit var binding: ActivityCalculadoraImcResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /**inflar el binding con la vista */
        binding = ActivityCalculadoraImcResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_calculadora_imc_result)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**
         * Cómo el dato que tenemos que recuperar tiene que se un Double,
         * se declara una variante:Double y se le dice que si el extra tiene un dato
         * (por eso el "?) me lo recupere, en caso contrario, si es null (?:) me
         * devuelva un valor Double. La constante "IMC_KEY" la priemra vez que se use
         * en la Activity, hay que importa la con ALT + INTRO
         * */
        val imc: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        /** Función que pone el texto en los textView de los resultados  */
        iniUI(imc)
        /** Función para capturar los listeners */
        intListener()

    }

    private fun intListener() {
        /** Método para volver atras en las Activity's */
        binding.btnReCalcular.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    /** Función que pone los textos en los testView */
    private fun iniUI(imc: Double) {
        /** El imc siempre muestra el valor que viene del intent */
        imc.toString().also { valor -> binding.tvImc.text = valor }
        /** Comprobar el resultado y poner el texto que toque en cada sitio */
        when (imc) {
            in 0.00..18.50 -> { // Bajo peso
                "Bajo peso".also { bajo -> binding.tvResultado.text = bajo }
                /** Para cambiar el color de un texto en un textView */
                binding.tvResultado.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                "Tu peso es demasiado bajo para tú altura".also { bajo ->
                    binding.tvDescripcion.text = bajo
                }
            }

            in 18.51..24.99 -> { // Peso normal
                "Peso normal".also { normal -> binding.tvResultado.text = normal }
                /** Para cambiar el color de un texto en un textView */
                binding.tvResultado.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                "Estás en el peso óptimo para tu altura".also { normal ->
                    binding.tvDescripcion.text = normal
                }
            }

            in 25.00..29.99 -> { // Sobrepeso
                "Sobrepeso".also { sobre -> binding.tvResultado.text = sobre }
                /** Para cambiar el color de un texto en un textView */
                binding.tvResultado.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                "Estás por encima de lo óptimo para tu altura".also { sobre ->
                    binding.tvDescripcion.text = sobre
                }
            }

            in 30.00..99.00 -> { // Obesidad
                "Obesidad".also { obeso -> binding.tvResultado.text = obeso }
                /** Para cambiar el color de un texto en un textView */
                binding.tvResultado.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                "Estás MUY por encima de lo óptimo para tu altura".also { obeso ->
                    binding.tvDescripcion.text = obeso
                }
            }

            else -> { // error
                val error = getString(R.string.error)
                error.also { error -> binding.tvResultado.text = error }
                error.also { error -> binding.tvImc.text = error }
                error.also { error -> binding.tvDescripcion.text = error }
            }
        }
    }
}