package com.nanduky.recyclerviewmain.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.recyclerviewmain.clases.CalendarDC
import com.nanduky.recyclerviewmain.databinding.ItemCalendarBinding

class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCalendarBinding.bind(view)
    fun render(calendar: CalendarDC) {
        binding.tvDay.text = calendar.day
        binding.tvMonth.text = calendar.month
        binding.tvYear.text = calendar.year
        binding.tvPlace.text = calendar.place
        binding.tvDoctor.text = calendar.doctor
    }
}