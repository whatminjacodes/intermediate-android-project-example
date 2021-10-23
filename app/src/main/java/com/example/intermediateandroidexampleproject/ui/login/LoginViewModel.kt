package com.example.intermediateandroidexampleproject.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val sharedPreferences: SharedPreferences) : ViewModel() {
    val redirectUri: String = "logintest://callback"
    val clientId: String = "bd3f948fa6dde4f62a6e"
    val clientSecret: String = ""

    val loginValidity = MutableLiveData<Boolean>()

    fun isLoginValid(validity: Boolean) {
        loginValidity.postValue(validity)
    }

    // todo: validate token
    fun validateToken() {

    }
}