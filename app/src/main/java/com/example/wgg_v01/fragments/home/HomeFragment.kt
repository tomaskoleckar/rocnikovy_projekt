package com.example.wgg_v01.fragments.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.CalendarActivity
import com.example.wgg_v01.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.startBtn.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentHome_to_trainType)
        }

        view.calendarBtn.setOnClickListener{
            val intent = Intent(context, CalendarActivity::class.java)
            startActivity(intent)
        }

        view.performanceBtn.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentHome_to_performanceFragment)
        }


        return view
    }

}