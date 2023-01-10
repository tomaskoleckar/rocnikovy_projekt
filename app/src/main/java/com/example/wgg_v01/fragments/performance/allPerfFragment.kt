package com.example.wgg_v01.fragments.performance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wgg_v01.MyApp.Companion.loggedUser
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import com.example.wgg_v01.data.realtions.UserExerciseRef
import kotlinx.android.synthetic.main.fragment_all_perf.view.*
import kotlinx.android.synthetic.main.fragment_train_type.view.*

class allPerfFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_perf, container, false)
        val adapter = PerfAdapter()
        val recyclerView = view.recyclerViewPerf
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getExercisesOfUsers.observe(viewLifecycleOwner, Observer { userExerciseRef ->
            adapter.setData(userExerciseRef)
        })


        return view
    }
}