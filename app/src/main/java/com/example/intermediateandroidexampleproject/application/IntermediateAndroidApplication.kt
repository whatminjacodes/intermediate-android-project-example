package com.example.intermediateandroidexampleproject.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class IntermediateAndroidApplication : Application() {
    companion object {
        const val PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@IntermediateAndroidApplication)
            modules(viewModelModule)
        }
    }
}