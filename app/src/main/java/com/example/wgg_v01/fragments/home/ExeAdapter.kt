package com.example.wgg_v01.fragments.home


import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wgg_v01.MyApp.Companion.currentFragment
import com.example.wgg_v01.R
import com.example.wgg_v01.data.Exercise
import kotlinx.android.synthetic.main.select_traintype.view.*

class ExeAdapter() : RecyclerView.Adapter<ExeAdapter.MyViewHolder>() {

    private var exeList = emptyList<Exercise>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.select_traintype, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = exeList[position]
        val imageName = currentItem.name.replace(" ", "").toLowerCase()
        println(imageName)
        val resources = holder.itemView.resources
        val resourceId = resources.getIdentifier(imageName, "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context).load(resourceId).into(holder.itemView.imageView)

        holder.itemView.textView2.text = currentItem.name
        holder.itemView.textView9.text = currentItem.part
        holder.itemView.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("exerciseName", currentItem.name)
            bundle.putString("exePart", currentItem.part)
            if(currentFragment == "train") {
                holder.itemView.findNavController()
                    .navigate(R.id.action_trainType_to_setPerfFragment, bundle)
            }
            else if(currentFragment == "perf"){
                holder.itemView.findNavController().navigate(R.id.action_performanceFragment_to_exeDataFragment, bundle )
            }
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