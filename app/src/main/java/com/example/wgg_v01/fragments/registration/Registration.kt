package com.example.wgg_v01.fragments.registration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.R
import com.example.wgg_v01.data.User
import com.example.wgg_v01.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.view.*

class Registration : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        view.registerBtn.setOnClickListener{

            insertDataToDatabase()

        }

        return view
    }

    private fun insertDataToDatabase() {
        val username = username3.text.toString()
        val password = password3.text.toString()
        val repassword = password4.text.toString()

        if(inputCheck(username, password, repassword)){
            if(password == repassword){
                val user = User( 0, username, password)
                mUserViewModel.addUser(user)
                Toast.makeText(requireContext(), "Successfully registered !", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_registration_to_login2)
            }
            else{
                Toast.makeText(requireContext(), "Passwords don't match !", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(requireContext(), "Please fill out all fields !", Toast.LENGTH_LONG).show()
        }
    }



    private fun inputCheck(username: String, password: String, repassword: String): Boolean{
        if(password == ""){
            return false
        }
        if(repassword == ""){
            return false
        }
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword))
    }
}