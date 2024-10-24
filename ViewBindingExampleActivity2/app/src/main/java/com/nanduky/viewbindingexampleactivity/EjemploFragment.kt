package com.nanduky.viewbindingexampleactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nanduky.viewbindingexampleactivity.databinding.FragmentEjemploBinding


class EjemploFragment : Fragment() {
    private var _vincularVistas: FragmentEjemploBinding? = null
    private val vincularVistas get() = _vincularVistas!!

    override fun onCreateView(
        miInflador: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //): View? { <= da una advertencia de no-null
    ): View {
        // return inflater.inflate(R.layout.fragment_ejemplo,container,false)
        _vincularVistas = FragmentEjemploBinding.inflate(miInflador, container, false)
        return vincularVistas.root
    }

    override fun onViewCreated(vista: View, savedInstanceState: Bundle?) {
        super.onViewCreated(vista, savedInstanceState)
        vincularVistas.btnToast.setOnClickListener {
            Toast.makeText(
                activity,
                "click",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}