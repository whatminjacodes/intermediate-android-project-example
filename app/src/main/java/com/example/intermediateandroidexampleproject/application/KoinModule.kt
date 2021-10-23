package com.example.intermediateandroidexampleproject.application

import com.example.intermediateandroidexampleproject.ui.bottomnav.activity.ActivityViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.home.HomeViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.readiness.ReadinessViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.sleep.SleepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ReadinessViewModel() }
    viewModel { SleepViewModel() }
    viewModel { ActivityViewModel() }
}