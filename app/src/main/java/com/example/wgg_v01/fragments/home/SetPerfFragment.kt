package com.example.wgg_v01.fragments.home

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.MyApp.Companion.loggedUser
import com.example.wgg_v01.R
import com.example.wgg_v01.data.User
import com.example.wgg_v01.data.UserViewModel
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import kotlinx.android.synthetic.main.fragment_set_perf.*
import kotlinx.android.synthetic.main.fragment_set_perf.view.*

class SetPerfFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_set_perf, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.submitBtn.setOnClickListener(){
            insertDataToDatabase()
        }

        view.exerciseText.text = arguments?.getString("exerciseName").toString()

        return view
    }

    private fun insertDataToDatabase() {
        val date = date.text.toString()
        val weight = weight.text.toString()
        val series = series.text.toString()
        val reps = reps.text.toString()
        val exeName = arguments?.getString("exerciseName").toString()
        val exePart = arguments?.getString("exePart").toString()

        if(inputCheck(date, weight ,series, reps)){
            val userExerciseRef = UserExerciseRef(0,loggedUser.toInt(),
                exeName,exePart, date, weight.toInt(), reps.toInt(), series.toInt())
            mUserViewModel.insertUserExerciseRef(userExerciseRef)

            Toast.makeText(requireContext(), "Successfully added !", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(date: String,weight: String, series: String, reps: String): Boolean{
        if(date == "" || weight.toInt() < 1 || reps.toInt() < 1 || series.toInt() < 1){
            return false
        }
        return !(TextUtils.isEmpty(date))
    }

}