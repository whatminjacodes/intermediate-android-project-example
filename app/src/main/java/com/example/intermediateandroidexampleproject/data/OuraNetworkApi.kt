package com.example.intermediateandroidexampleproject.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

import retrofit2.http.GET


interface OuraNetworkApi {


    @GET("/oauth/authorize")
    suspend fun getOuraAccessToken(
        @Query("response_type") code: String?,
        @Query("client_id") clientId: String?,
        @Query("redirect_uri") redirectUri: String?
    ): OuraResponse

}