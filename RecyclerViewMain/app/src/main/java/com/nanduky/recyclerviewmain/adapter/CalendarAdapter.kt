package com.nanduky.recyclerviewmain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanduky.recyclerviewmain.R
import com.nanduky.recyclerviewmain.clases.CalendarDC

class CalendarAdapter(private val listCalendar: List<CalendarDC>):RecyclerView.Adapter<CalendarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CalendarViewHolder(layoutInflater.inflate(R.layout.item_calendar,parent,false))
    }

    override fun getItemCount() = listCalendar.size


    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item = listCalendar[position]
        holder.render(item)
    }
}