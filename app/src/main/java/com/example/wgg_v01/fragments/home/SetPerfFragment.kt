package com.example.wgg_v01.fragments.home

import android.os.Bundle
import android.text.Editable
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
import java.text.SimpleDateFormat
import java.util.*

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
        val currentDate = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("d.M.y", Locale.getDefault())
        val date = dateFormat.format(currentDate)
        view.date.text = Editable.Factory.getInstance().newEditable(date)
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
        val regex = Regex("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$")
        if(!regex.matches(date) ||date == "" || weight.toInt() < 1 || reps.toInt() < 1 || series.toInt() < 1){
            return false
        }
        return !(TextUtils.isEmpty(date))
    }

}