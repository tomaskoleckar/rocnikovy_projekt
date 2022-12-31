package com.example.wgg_v01.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
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
            findNavController().navigate(R.id.action_setPerfFragment_to_trainType)
        }

        view.exerciseText.text = arguments?.getString("exerciseName").toString()

        return view
    }

    private fun insertDataToDatabase() {

    }

}