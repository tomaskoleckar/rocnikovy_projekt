package com.example.wgg_v01.fragments.performance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import com.example.wgg_v01.fragments.home.ExeAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.MyApp
import com.example.wgg_v01.MyApp.Companion.currentFragment
import kotlinx.android.synthetic.main.fragment_performance.*
import kotlinx.android.synthetic.main.fragment_performance.view.*


class performanceFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        currentFragment = "perf"
        val view = inflater.inflate(R.layout.fragment_performance, container, false)
        view.allExeBtn.setOnClickListener{
            findNavController().navigate(R.id.action_performanceFragment_to_allPerfFragment)
        }
        val adapter = ExeAdapter()
        val recyclerView = view.recyclerView2
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllExe.observe(viewLifecycleOwner, Observer{ exercise ->
            adapter.setData(exercise)
        })

        return view
    }

}