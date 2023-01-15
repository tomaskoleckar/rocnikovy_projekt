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
import com.example.wgg_v01.fragments.performance.adapters.ExeAdapter
import kotlinx.android.synthetic.main.fragment_exe_data.view.*
import kotlinx.android.synthetic.main.fragment_perf_data.view.*

class ExeDataFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exe_data, container, false)
        val adapter = ExeAdapter()
        val recyclerView = view.exeRecycle
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        view.exeName2.text = arguments?.getString("exerciseName").toString()
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getExeData(loggedUser.toInt(),arguments?.getString("exerciseName").toString()).observe(viewLifecycleOwner, Observer { exeData ->
            adapter.setData(exeData)
        })

        return view
    }

}