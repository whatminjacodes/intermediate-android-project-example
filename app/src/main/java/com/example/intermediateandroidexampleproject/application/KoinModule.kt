package com.example.intermediateandroidexampleproject.application

import com.example.intermediateandroidexampleproject.data.NetworkApi
import com.example.intermediateandroidexampleproject.data.PokemonRepository
import com.example.intermediateandroidexampleproject.ui.bottomnav.activity.ActivityViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.home.HomeViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.readiness.ReadinessViewModel
import com.example.intermediateandroidexampleproject.ui.bottomnav.sleep.SleepViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ReadinessViewModel() }
    viewModel { SleepViewModel() }
    viewModel { ActivityViewModel() }

    single { PokemonRepository(get()) }
}

val networkingModule = module {
    single { createRetrofit(createOkHttpClient()) }
    single { createNetworkApi(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://pokeapi.co/")
        .client(okHttpClient)
        .build()
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}