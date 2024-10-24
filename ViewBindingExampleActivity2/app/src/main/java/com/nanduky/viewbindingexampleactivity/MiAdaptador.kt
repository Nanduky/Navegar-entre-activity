package com.nanduky.viewbindingexampleactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.viewbindingexampleactivity.databinding.ItemSemanaListBinding


class MiAdaptador(private val miListaMain: List<String>) :
    RecyclerView.Adapter<MiAdaptador.TitularVista>() {

    override fun onBindViewHolder(titular: TitularVista, posicion: Int) {
        val item: String = miListaMain[posicion]
        titular.unir(item)
    }

    override fun onCreateViewHolder(vistaPadre: ViewGroup, viewType: Int): TitularVista {
        val layoutInflador = LayoutInflater.from(vistaPadre.context)

        return TitularVista(layoutInflador.inflate(R.layout.item_semana_list, vistaPadre, false))
    }

    override fun getItemCount() = miListaMain.size

    class TitularVista(vista: View) : RecyclerView.ViewHolder(vista) {
        //val tvSuperhero = view.findViewById<TextView>(R.id.tvSuperHero)
        private val vincularVistas = ItemSemanaListBinding.bind(vista)
        fun unir(semana: String) {
            vincularVistas.tvSemana.text = semana

        }
    }
}