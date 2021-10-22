package com.example.intermediateandroidexampleproject.application

import android.content.Context
import com.example.intermediateandroidexampleproject.ui.bottomnav.activity.ActivityViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.home.HomeViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.readiness.ReadinessViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.sleep.SleepViewModel
import com.example.intermediateandroidexampleproject.ui.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel() }
    viewModel { ReadinessViewModel() }
    viewModel { SleepViewModel() }
    viewModel { ActivityViewModel() }

    single { androidContext().getSharedPreferences("com.example.intermediateandroidexampleproject", Context.MODE_PRIVATE) }
}