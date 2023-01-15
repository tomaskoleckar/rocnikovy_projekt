package com.example.wgg_v01.fragments.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wgg_v01.MyApp
import com.example.wgg_v01.MyApp.Companion.currentFragment
import com.example.wgg_v01.R
import com.example.wgg_v01.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_train_type.view.*

class TrainType : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_train_type, container, false)
        currentFragment = "train"
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }
    private fun searchDatabase(query: String){
        val searchQuery = "%$query%"
        val adapter = ExeAdapter()
        mUserViewModel.searchExe(searchQuery).observe(viewLifecycleOwner, Observer { list ->
            list.let {
                adapter.setData(it)
            }
        })
    }

}