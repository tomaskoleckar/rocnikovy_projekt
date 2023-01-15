package com.example.wgg_v01.fragments.performance

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wgg_v01.MyApp.Companion.loggedUser
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import com.example.wgg_v01.data.realtions.UserExerciseRef
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        view.exerciseText2.setText(args.currentPerf.exerciseName)
        view.dateUp.setText(args.currentPerf.date)
        view.weightUp.setText(args.currentPerf.weight.toString())
        view.repsUp.setText(args.currentPerf.reps.toString())
        view.seriesUp.setText(args.currentPerf.series.toString())

        view.updateBtn.setOnClickListener{
            updatePerf()
        }

        return view
    }

    private fun updatePerf(){
        val date = dateUp.text.toString()
        val weight = weightUp.text.toString()
        val reps = repsUp.text.toString()
        val series = seriesUp.text.toString()
        val bundle = Bundle()
        bundle.putString("exerciseName", args.currentPerf.exerciseName)
        bundle.putString("date", date)
        if(inputCheck(date,weight,reps,series)){
            val updatedPerf = UserExerciseRef(args.currentPerf.userExId,args.currentPerf.userId,args.currentPerf.exerciseName,args.currentPerf.exercisePart,date,weight.toInt(),series.toInt(),reps.toInt())
            mUserViewModel.updatePerf(updatedPerf)
            Toast.makeText(requireContext(), "Updated successfully!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_perfData, bundle)
        }
    }

    private fun inputCheck(date: String,weight: String, series: String, reps: String): Boolean{
        val regex = Regex("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$")
        if(!regex.matches(date) ||date == "" || weight.toInt() < 1 || reps.toInt() < 1 || series.toInt() < 1){
            return false
        }
        return !(TextUtils.isEmpty(date))
    }

    }