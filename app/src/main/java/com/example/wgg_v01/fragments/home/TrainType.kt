package com.example.wgg_v01.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_train_type.view.*
import kotlinx.android.synthetic.main.select_traintype.*

class TrainType : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_train_type, container, false)

        val adapter = ExeAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllExe.observe(viewLifecycleOwner, Observer{ exercise ->
            adapter.setData(exercise)
        })

        return view
    }

}