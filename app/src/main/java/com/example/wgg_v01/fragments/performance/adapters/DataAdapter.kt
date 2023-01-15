package com.example.wgg_v01.fragments.performance.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.fragments.performance.PerfData
import com.example.wgg_v01.fragments.performance.PerfDataDirections
import kotlinx.android.synthetic.main.view_perf_data.view.*

class DataAdapter(context: PerfData) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    private var perfList = emptyList<UserExerciseRef>()
    private lateinit var mUserViewModel: UserViewModel
    private val context = context
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_perf_data, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        mUserViewModel = ViewModelProvider(context).get(UserViewModel::class.java)

        val currentItem = perfList[position]
        holder.itemView.repsPerf.text = currentItem.reps.toString()
        holder.itemView.seriesPerf.text = currentItem.series.toString()
        holder.itemView.weightPerf.text = currentItem.weight.toString() + "kg"

        holder.itemView.changeBtn.setOnClickListener{
            val action = PerfDataDirections.actionPerfDataToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
        holder.itemView.deleteBtn.setOnClickListener{
            deletePerf(holder,currentItem)
        }

    }

    private fun deletePerf(holder: MyViewHolder, currentItem: UserExerciseRef) {
        val builder = AlertDialog.Builder(holder.itemView.context)
        builder.setPositiveButton("Yes"){_, _ ->
            mUserViewModel.deletePerf(currentItem)
            Toast.makeText(holder.itemView.context, "Succesfully removed !", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_, _ ->

        }
        builder.setTitle("Delete ${currentItem.exerciseName} ?")
        builder.setMessage("Are you sure you want to delete this ${currentItem.exerciseName} performance ?")
        builder.show()

    }

    override fun getItemCount(): Int {
        return perfList.size
    }

    fun setData(userExerciseRef: List<UserExerciseRef>){
        this.perfList = userExerciseRef
        notifyDataSetChanged()
    }

}