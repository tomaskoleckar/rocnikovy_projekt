package com.example.wgg_v01.fragments.performance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.data.User
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import kotlinx.android.synthetic.main.select_traintype.view.*
import kotlinx.android.synthetic.main.view_performances.view.*

class PerfAdapter() : RecyclerView.Adapter<PerfAdapter.MyViewHolder>() {

    private var perfList = emptyList<UserExerciseRef>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_performances, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = perfList[position]
        holder.itemView.textView3.text = currentItem.date
        holder.itemView.textView4.text = currentItem.exerciseName
        holder.itemView.textView5.text = currentItem.exercisePart
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("exerciseName", currentItem.exerciseName)
            bundle.putString("date", currentItem.date)
            holder.itemView.findNavController()
                .navigate(R.id.action_allPerfFragment_to_perfData, bundle)
        }


    }

    override fun getItemCount(): Int {
        return perfList.size
    }

    fun setData(userExerciseRef: List<UserExerciseRef>){
        val uniqueDataSet = mutableListOf<UserExerciseRef>()
        userExerciseRef.forEach { item ->
            if(!uniqueDataSet.any { it.date == item.date && it.exerciseName == item.exerciseName}){
                uniqueDataSet.add(item)
            }
        }
        this.perfList = uniqueDataSet
        notifyDataSetChanged()
    }

}