package com.example.wgg_v01.fragments.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.wgg_v01.HomeActivity
import com.example.wgg_v01.R
import com.example.wgg_v01.data.User
import com.example.wgg_v01.data.UserDataBase
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : Fragment() {

    private lateinit var userDB: UserDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        if (container != null) {
            userDB = UserDataBase.getDatabase(container.context)
        }


        view.loginBtn.setOnClickListener{

            readData()

        }


        view.floatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_login2_to_registration)
        }






        return view
    }

    private suspend fun displayData(user: User){
        withContext(Dispatchers.Main){
            val username = username2.text.toString()
            val password = password2.text.toString()
            if(username == user.username && password == user.password){
                Toast.makeText(requireContext(), "Successfully logged in !", Toast.LENGTH_LONG).show()
                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(requireContext(), "Username or password is incorrect !", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun readData() {
        val username = username2.text.toString()
        val password = password2.text.toString()


        if(inputCheck(username, password)){
            var user: User

            GlobalScope.launch {
                    user = userDB.userDao().findUser(username,password)
                    if(user != null){
                        displayData(user)
                    }
                    else{
                        withContext(Dispatchers.Main) {
                            Toast.makeText(requireContext(), "Username or password is incorrect !", Toast.LENGTH_LONG).show()
                        }
                    }

            }


        }
        else{
            Toast.makeText(requireContext(), "Please fill out all fields !", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(username: String, password: String): Boolean{
        if(password == ""){
            return false
        }
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password))
    }

}