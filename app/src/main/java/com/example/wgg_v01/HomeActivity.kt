package com.example.wgg_v01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    var trainBtn: Button? = null
    var calendarBtn: Button? = null
    var performanceBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        trainBtn = findViewById<View>(R.id.startBtn) as Button
        calendarBtn = findViewById<View>(R.id.calendarBtn) as Button
        performanceBtn = findViewById<View>(R.id.performanceBtn) as Button




        trainBtn!!.setOnClickListener(){
            setContentView(R.layout.select_traintype)
        }
        calendarBtn!!.setOnClickListener(){
            val intent = Intent(applicationContext, CalendarActivity::class.java)
            startActivity(intent)
        }
        performanceBtn!!.setOnClickListener(){
            val intent = Intent(applicationContext, PerformanceActivity::class.java)
            startActivity(intent)
        }


    }

}