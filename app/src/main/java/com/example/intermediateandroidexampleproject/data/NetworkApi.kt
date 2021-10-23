package com.example.intermediateandroidexampleproject.data

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET


interface NetworkApi {

    @GET("api/v2/pokemon")
    suspend fun getPokemon(@Query("limit") maxPokemon: Int): Response

}