package com.nanduky.cursokotlindesde0.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.cursokotlindesde0.R
import com.nanduky.cursokotlindesde0.databinding.ActivitySuperHeroListBinding
import com.nanduky.cursokotlindesde0.superheroapp.DetallesSuperHeroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class SuperHeroListActivity : AppCompatActivity() {

    /** Crear el binding */
    private lateinit var bindingSHLA: ActivitySuperHeroListBinding
    private lateinit var retrofitSHLA: Retrofit

    /** Crear el adapter */
    private lateinit var adapterSHLA: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /** Inflar el binding */
        bindingSHLA = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(bindingSHLA.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_super)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Iniciar el retrofit*/
        retrofitSHLA = getRetrofitSHLA()
        /** Función para iniciar los UI que aún no se que significa */
        initUI()
    }

    private fun initUI() {
        bindingSHLA.svSuper.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /** Función que se llamará al pulsar el botón de buscar */
            override fun onQueryTextSubmit(query: String?): Boolean {
                /** Nos pasa un query o una String vacía, pero no null */
                buscarPorNombreSHLA(query.orEmpty())
                return false
            }

            /** Función que se llamará mientras se escribe, aquí quedará sin uso */
            override fun onQueryTextChange(newText: String?) = false
        })

        /** crear el adapter, no hay que pasar le parámetro porque se inicializó vacía con emptyList() */
        /** ahora le pasamos la función lambda para llamar al onclick */
        adapterSHLA = SuperHeroAdapter {superHeroIdIT -> irDetalleSuperHeroActivity(superHeroIdIT)}
        /** variable para no repetir el binding */
        val rvSuper = bindingSHLA.rvSuper
        /** Evitar que el recyclerView cambie de tamaño */
        rvSuper.setHasFixedSize(true)
        /** Hay que pasarle un manager */
        rvSuper.layoutManager = LinearLayoutManager(this)
        /** Pasarle el adapte que emos creado */
        rvSuper.adapter = adapterSHLA
    }

    private fun buscarPorNombreSHLA(query: String) {
        /** Mostrar el pregressBar */
        bindingSHLA.pbSuper.isVisible = true
        /** Corrutina en un hilo secundarío*/
        CoroutineScope(Dispatchers.IO).launch {
            /** lo que se haga aquí es en el hilo secundarío */
            val miRespuesta: Response<SuperHeroDataClassResponse> =
                retrofitSHLA.create(ApiServiceSuperInterface::class.java).getSuperHeroInterface(query)
            if (miRespuesta.isSuccessful) {
                val respuestaBPN: SuperHeroDataClassResponse? = miRespuesta.body()
                if (respuestaBPN != null) {
                    /** Corre en el hilo principal lo que meta entre las llaves */
                    runOnUiThread {
                        bindingSHLA.pbSuper.isVisible = false

                        if (respuestaBPN.respuestaSHDCR == "error") {
                            Toast.makeText(bindingSHLA.pbSuper.context,"No existe",Toast.LENGTH_SHORT).show()
                        } else {
                            /*Se llama al método o función con la lista de heroes de la busqueda */
                            adapterSHLA.actualizaListaSHA(respuestaBPN.resultadoSuperHeroeSHDCR)
                        }
                    }
                }
            } else {
                Log.i("Fer", " no Funciona :(")
            }
        }
    }

    /** Creación de Retrofit */
    private fun getRetrofitSHLA(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            /** Siempre con eñ "/" final */
            .addConverterFactory(GsonConverterFactory.create())
            /** para convertir */
            .build()
        /** Construye te */
    }

    /**  Función para ir a la DetalleSuperHeroActivity con un parámetro*/
    private fun irDetalleSuperHeroActivity(id: String) {
        val detallesSuperHeroActivityIntent = Intent(this,DetallesSuperHeroActivity::class.java)
        /**  Hay que importa el EXTRA_ID */
        detallesSuperHeroActivityIntent.putExtra(EXTRA_ID,id)
        startActivity(detallesSuperHeroActivityIntent)
    }
}
