package com.example.wgg_v01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var signin = findViewById(R.id.signin) as Button
        var signup = findViewById(R.id.signup) as Button

        signup.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


            }

        })

        signin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


            }

        })



    }
}