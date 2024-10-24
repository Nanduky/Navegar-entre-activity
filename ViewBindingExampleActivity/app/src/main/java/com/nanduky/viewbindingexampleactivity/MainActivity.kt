package com.nanduky.viewbindingexampleactivity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanduky.viewbindingexampleactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val list = listOf("Spederman", "Super man", "Iron man", "Black panter", "Hulk", "Thor")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowFragment.setOnClickListener { openFragment() }
        binding.btnShowRV.setOnClickListener { showRecyclerView() }
    }

    private fun showRecyclerView() {
        Log.i(" Main"," dentro de showRecyclerView()")
        binding.fragmentContainer.visibility = View.GONE
        binding.rvList.visibility = View.VISIBLE

        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(list)
        binding.rvList.adapter = adapter
    }

    private fun openFragment() {
        Log.i(" Main"," dentro de openFragment()")
        binding.fragmentContainer.visibility = View.VISIBLE
        binding.rvList.visibility = View.GONE

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, ExampleFragment())
        fragmentTransaction.commit()
    }
}