package com.example.intermediateandroidexampleproject.data

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET


interface NetworkApi {

    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(
        @Field("client_id") clientId: String?,
        @Field("client_secret") clientSecret: String?,
        @Field("code") code: String?
    ): Call<AccessToken?>?

    // @GET("/users/{user}/repos")
    // fun reposForUser(@Path("user") user: String?): Call<List<GitHubRepo?>?>?

    @GET("api/v2/pokemon")
    suspend fun getPokemon(@Query("limit") maxPokemon: Int): Response

}