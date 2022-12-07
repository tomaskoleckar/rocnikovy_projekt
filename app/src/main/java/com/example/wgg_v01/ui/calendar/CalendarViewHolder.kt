package com.example.wgg_v01.ui.calendar


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.ui.calendar.CalendarAdapter.OnItemListener


class CalendarViewHolder internal constructor(itemView: View, onItemListener: OnItemListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val dayOfMonth: TextView?
    private val onItemListener: OnItemListener

    init {
        dayOfMonth = itemView.findViewById(R.id.cellDayText) as TextView
        this.onItemListener = onItemListener
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        onItemListener.onItemClick(adapterPosition, dayOfMonth?.text as String)
    }
}