package com.example.wgg_v01.fragments.performance.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.data.realtions.UserExerciseRef
import kotlinx.android.synthetic.main.fragment_set_perf.view.*
import kotlinx.android.synthetic.main.view_exe_data.view.*
import kotlinx.android.synthetic.main.view_performances.view.*

class ExeAdapter() : RecyclerView.Adapter<ExeAdapter.MyViewHolder>() {

    private var exeList = emptyList<UserExerciseRef>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_exe_data, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = exeList[position]
        holder.itemView.dateExe.text = currentItem.date
        holder.itemView.weightExe.text = currentItem.weight.toString()
        holder.itemView.repsExe.text = currentItem.reps.toString()
        holder.itemView.seriesExe.text = currentItem.series.toString()

    }

    override fun getItemCount(): Int {
        return exeList.size
    }

    fun setData(userExerciseRef: List<UserExerciseRef>){
        this.exeList = userExerciseRef
        notifyDataSetChanged()
    }

}