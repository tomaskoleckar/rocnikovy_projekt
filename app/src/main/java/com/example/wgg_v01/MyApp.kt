package com.example.wgg_v01

import android.app.Application

class MyApp: Application() {
    companion object {
        var loggedUser = "none"
    }

    override fun onCreate() {
        super.onCreate()
    }
}