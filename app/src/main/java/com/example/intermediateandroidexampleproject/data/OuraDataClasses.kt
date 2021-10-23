package com.example.intermediateandroidexampleproject.data

data class OuraResponse(
    val code: String
)

data class OuraRequest(
    val code: String?,
    val clientId: String?,
    val redirectUri: String?
)