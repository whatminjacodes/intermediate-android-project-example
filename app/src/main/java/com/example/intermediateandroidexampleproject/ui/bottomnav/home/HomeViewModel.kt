package com.example.intermediateandroidexampleproject.ui.bottomnav.home

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.intermediateandroidexampleproject.application.IntermediateAndroidApplication

class HomeViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    fun checkForAccessToken() {
        val accessToken = sharedPreferences.getString(IntermediateAndroidApplication.PREF_ACCESS_TOKEN, null)!!

        if (accessToken != null) {
            Log.d("test", accessToken)
        }
    }

    fun testing() {
        Log.d("test", "testing")
    }
}