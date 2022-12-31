package com.example.wgg_v01.fragments.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.data.Exercise
import kotlinx.android.synthetic.main.select_traintype.view.*

class ExeAdapter: RecyclerView.Adapter<ExeAdapter.MyViewHolder>() {

    private var exeList = emptyList<Exercise>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.select_traintype, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = exeList[position]
        holder.itemView.exercise1.text = currentItem.name
        holder.itemView.exercise1.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("exerciseName", holder.itemView.exercise1.text.toString())
            holder.itemView.findNavController().navigate(R.id.action_trainType_to_setPerfFragment, bundle)
        }

    }

    override fun getItemCount(): Int {
        return exeList.size
    }

    fun setData(exercise: List<Exercise>){
        this.exeList = exercise
        notifyDataSetChanged()
    }

}