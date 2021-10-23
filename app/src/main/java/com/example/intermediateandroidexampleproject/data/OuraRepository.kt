package com.example.intermediateandroidexampleproject.data

class OuraRepository(
    private val ouraApi: OuraNetworkApi
) {
    suspend fun getOuraAccessToken(ouraRequest: OuraRequest) =
        ouraApi.getOuraAccessToken(ouraRequest.code, ouraRequest.clientId, ouraRequest.redirectUri)
}