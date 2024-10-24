package com.nanduky.viewbindingexampleactivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nanduky.viewbindingexampleactivity.databinding.FragmentExampleBinding


class ExampleFragment : Fragment() {
    private var _binding: FragmentExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    //): View? { <= da una advertencia de no-null
    ): View {
        // return inflater.inflate(R.layout.fragment_example,container,false)
        _binding = FragmentExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToast.setOnClickListener{Toast.makeText(activity,"click",Toast.LENGTH_SHORT).show()}
    }


}