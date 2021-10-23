package com.example.intermediateandroidexampleproject.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val sharedPreferences: SharedPreferences) : ViewModel() {
    val loginValidity = MutableLiveData<Boolean>()

    fun isLoginValid(validity: Boolean) {
        loginValidity.postValue(validity)
    }

    // todo: validate token
    fun validateToken() {

    }
}