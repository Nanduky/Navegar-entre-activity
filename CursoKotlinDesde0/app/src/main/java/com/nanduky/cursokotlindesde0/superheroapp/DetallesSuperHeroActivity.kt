package com.nanduky.cursokotlindesde0.superheroapp

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivityDetallesSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetallesSuperHeroActivity : AppCompatActivity() {

    /* Companion para acceder a su contenido desde cualquier lugar */
    companion object {
        /* Constante para el putExtra*/
        const val EXTRA_ID = "extra_id"
    }

    /** Crear el binding */
    private lateinit var bindingDSHA: ActivityDetallesSuperHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /** Inflar el binding */
        bindingDSHA = ActivityDetallesSuperHeroBinding.inflate(layoutInflater)
        setContentView(bindingDSHA.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_detalles_super)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Recuperar el putExtra de irDetalleSuperHeroActivity de la activity principal*/
        val idPutExtra: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        /** Nuevo método que se encargará de hacer la petición a internet */
        getSuperHeroInformacion(idPutExtra)
    }

    /** Método que se encargará de hacer la petición a internet */
    private fun getSuperHeroInformacion(idPutExtra: String) {
        /** Volver a llamar al hilo secundario */
        CoroutineScope(Dispatchers.IO).launch {
            /** Llamamos al retrofit y lo guardamos en una variable*/
            val miDetalleRespuesta =
                getRetrofitDSHA().create(ApiServiceSuperInterface::class.java)
                    .getSuperHeroIdInterface(idPutExtra)
            /** Aqui simplificamos los 2 if de SuperHeroListActivity/buscarPorNombreSHLA a 1 */
            if (miDetalleRespuesta.body() != null) {
                /** Llamamos la hilo principal */
                runOnUiThread {
                    /** Creamos una función para sacar código de aquí y quede más ordenado */
                    creaUI(
                        /** le pasamos de parámetro el body() y le decimos que no es nulo seguro */
                        miDetalleRespuesta.body()!!
                    )
                }
            } else {
                Log.i("fer", "error")
            }
        }
    }

    private fun creaUI(superHeroBody: SuperHeroDataClassDetallesResponse) {
        /* Pasarle a la vista la imagen */
        Picasso.get().load(superHeroBody.imageSuperSHDCDR.urlImageSuper)
            .into(bindingDSHA.imSuperhero)
        /* Pasar el nombre del super */
        miniComprobarNull(superHeroBody.nombreSuperSHDCDR, bindingDSHA.tvSuperHeroNombre)

        /* Función para pintar la grafica de los stat */

        /* Pasarle el nombre real */
        miniComprobarNull(
            superHeroBody.biografiaSHDCDR.nombreReal,
            bindingDSHA.tvSuperHeroNombreReal
        )
        /* Pasarle la editarial */
        miniComprobarNull(superHeroBody.biografiaSHDCDR.editorial, bindingDSHA.tvSuperHeroEditorial)
        /* Pasarle el genero */
        miniComprobarNull(superHeroBody.appearanceSHDCDR.generoSuper, bindingDSHA.tvSuperGenero)
        /* Pasarle la raza */
        miniComprobarNull(superHeroBody.appearanceSHDCDR.razaSuper, bindingDSHA.tvSuperRaza)
        /* pasar la altura */
        val alturaSuperHero: List<String> = superHeroBody.appearanceSHDCDR.alturaSuper
        if (alturaSuperHero.size == 2)  miniComprobarNull(alturaSuperHero[1], bindingDSHA.tvSuperAltura)
        else miniComprobarNull("? cm", bindingDSHA.tvSuperAltura)
        /* Pasar el peso */
        val pesoSuperHero: List<String> = superHeroBody.appearanceSHDCDR.pesoSuper
        if (pesoSuperHero.size == 2)  miniComprobarNull(pesoSuperHero[1], bindingDSHA.tvSuperPeso)
        else miniComprobarNull("? kg", bindingDSHA.tvSuperPeso)


//
//        bindingDSHA.tvSuperPeso.text = pesoSuperHero[1]
        preparaStats(superHeroBody.powerstatsSuperSHDCDR)
    }

    /* Función que comprueba los campos vacios */
    private fun miniComprobarNull(body: String, view: TextView) {
        if (body.isEmpty() || body == "null") {
            view.text = getText(R.string.no_info)
        } else {
            view.text = body
        }
    }


    /* Función para modificar los valores del xml */
    private fun preparaStats(powerstatsSuperSHDCDR: PowerStarItemResponse) {
        /* Se llama a la función pasando le el nombre de la view y el int de @SerializedName("intelligence") val  inteligencia: String, */

        val viewInteligencia = bindingDSHA.viewInteligencia
        val tvInteligenciaPor = bindingDSHA.tvInteligenciaPor
        val viewFuerza = bindingDSHA.viewFuerza
        val tvFuerzaPor = bindingDSHA.tvFuerzaPor
        val viewVelocidad = bindingDSHA.viewVelocidad
        val tvVelocidadPor = bindingDSHA.tvVelocidadPor
        val viewDurabilidad = bindingDSHA.viewDurabilidad
        val tvDurabilidadPor = bindingDSHA.tvDurabilidadPor
        val viewPoder = bindingDSHA.viewPoder
        val tvPoderPor = bindingDSHA.tvPoderPor
        val viewCombate = bindingDSHA.viewCombate
        val tvCombatePor = bindingDSHA.tvCombatePor

        compruebaNull(powerstatsSuperSHDCDR.inteligencia, viewInteligencia, tvInteligenciaPor)
        compruebaNull(powerstatsSuperSHDCDR.fuerza, viewFuerza, tvFuerzaPor)
        compruebaNull(powerstatsSuperSHDCDR.velocidad, viewVelocidad, tvVelocidadPor)
        compruebaNull(powerstatsSuperSHDCDR.durabilidad, viewDurabilidad, tvDurabilidadPor)
        compruebaNull(powerstatsSuperSHDCDR.poder, viewPoder, tvPoderPor)
        compruebaNull(powerstatsSuperSHDCDR.combate, viewCombate, tvCombatePor)

    }

    // Función que compureba los PowerStarItemResponse que vienen null */
    private fun compruebaNull(powerItem: String, view: View, porcentaje: TextView) {
        if (powerItem != "null") {
            actualizaAltura(view, powerItem)
            porcentaje.text = StringBuilder(powerItem).append("%")
        } else {
            actualizaAltura(view, "0")
            porcentaje.text = "?%"
        }
    }

    /* Función para cambiar los parámetro a la view y no repetir código */
    private fun actualizaAltura(view: View, stat: String) {
        /* Se crea una variable que contendrá los parámetros de los layouts de la vista */
        val parametros = view.layoutParams
        /* a los parámetros de la vista que recibe, se le cambia la altura con la fun pxToDp */
        parametros.height = pxToDp(stat.toFloat())
        /* a la vista que llega por parámetros se le pasa los nuevos parámetros */
        view.layoutParams = parametros

    }

    /* Función para convertir los pixeles a DensidadPantalla */
    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }

    /** Creación de Retrofit */
    private fun getRetrofitDSHA(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            /** Siempre con el "/" final */
            .addConverterFactory(GsonConverterFactory.create())
            /** para convertir */
            .build()
        /** Construye te */
    }

}