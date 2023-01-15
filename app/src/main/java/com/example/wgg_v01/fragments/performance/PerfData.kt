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
import com.example.wgg_v01.fragments.performance.adapters.DataAdapter
import kotlinx.android.synthetic.main.fragment_perf_data.view.*

class PerfData : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perf_data, container, false)
        val adapter = DataAdapter(this)
        val recyclerView = view.perfRecycle
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        view.datePerf.text = arguments?.getString("date").toString()
        view.exeName.text = arguments?.getString("exerciseName").toString()
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getPerfData(loggedUser.toInt(),arguments?.getString("exerciseName").toString(),arguments?.getString("date").toString()).observe(viewLifecycleOwner, Observer { perfData ->
            adapter.setData(perfData)
        })

        return view
    }

}