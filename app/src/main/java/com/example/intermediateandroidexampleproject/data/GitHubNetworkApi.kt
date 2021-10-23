package com.example.intermediateandroidexampleproject.data

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*


interface GitHubNetworkApi {

    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(
        @Field("client_id") clientId: String?,
        @Field("client_secret") clientSecret: String?,
        @Field("code") code: String?
    ): Call<GitHubNetworkApi?>?

    @GET("/users/{user}/repos")
    fun reposForUser(@Path("user") user: String?): Call<List<GitHubRepo?>?>?
}