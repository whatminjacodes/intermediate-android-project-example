package com.example.intermediateandroidexampleproject.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("api/v2/pokemon")
    suspend fun getPokemon(@Query("limit") maxPokemon: Int): Response
}