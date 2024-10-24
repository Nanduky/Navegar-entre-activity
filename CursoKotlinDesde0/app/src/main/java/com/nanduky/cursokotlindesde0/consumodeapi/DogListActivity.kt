package com.nanduky.cursokotlindesde0.consumodeapi

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.cursokotlindesde0.databinding.ActivityDogListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogListActivity : AppCompatActivity(), OnQueryTextListener {

    /** Crear el binding */
    private lateinit var bindingDLA: ActivityDogListBinding
    private lateinit var adapterDLA: DogAdapter
    private val dogImageMutListDLA = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** inflar el binding */
        bindingDLA = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(bindingDLA.root)
        bindingDLA.svDog.setOnQueryTextListener(this)
        iniRecyclerViewDLA()

    }

    private fun iniRecyclerViewDLA() {
        adapterDLA = DogAdapter(dogImageMutListDLA)
        bindingDLA.rvDog.layoutManager = LinearLayoutManager(this)
        bindingDLA.rvDog.adapter = adapterDLA
    }

    private fun getRetrofitDLA(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun buscaPorNombreDLA(queryDLA: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val llamadaDLA = getRetrofitDLA().create(APIServiceDogInterface::class.java)
                .getDogsPorRaza("$queryDLA/images")
            val cachorrosDLA = llamadaDLA.body()
            runOnUiThread {
                if (llamadaDLA.isSuccessful) {
                    val imagenesDLA = cachorrosDLA?.imagenessDogDRDC ?: emptyList()
                    dogImageMutListDLA.clear()
                    dogImageMutListDLA.addAll(imagenesDLA)
                    adapterDLA.notifyDataSetChanged()
                } else {
                    showErrorDLA()
                }
                esconderTecladoDLA()
            }
        }
    }

    private fun esconderTecladoDLA() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(bindingDLA.mainDogList.windowToken,0)
    }


    private fun showErrorDLA() {
        Toast.makeText(this,"Error al cargar las imagenes",Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            buscaPorNombreDLA(query.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?) =  true
}