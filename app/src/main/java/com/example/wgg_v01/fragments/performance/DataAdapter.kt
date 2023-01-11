package com.example.wgg_v01.fragments.performance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import kotlinx.android.synthetic.main.fragment_perf_data.view.*
import kotlinx.android.synthetic.main.view_perf_data.view.*
import kotlinx.android.synthetic.main.view_performances.view.*

class DataAdapter() : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    private var perfList = emptyList<UserExerciseRef>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_perf_data, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = perfList[position]
        holder.itemView.repsPerf.text = currentItem.reps.toString()
        holder.itemView.seriesPerf.text = currentItem.series.toString()
        holder.itemView.weightPerf.text = currentItem.weight.toString() + "kg"

    }

    override fun getItemCount(): Int {
        return perfList.size
    }

    fun setData(userExerciseRef: List<UserExerciseRef>){
        this.perfList = userExerciseRef
        notifyDataSetChanged()
    }

}