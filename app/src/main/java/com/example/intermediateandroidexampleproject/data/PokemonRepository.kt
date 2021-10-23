package com.example.intermediateandroidexampleproject.data

import com.example.intermediateandroidexampleproject.data.NetworkApi
import com.example.intermediateandroidexampleproject.data.PokemonRequest

class PokemonRepository(
    private val pokemonApi: NetworkApi
) {
    // todo: error handling
    suspend fun getPokemon(pokemonRequest: PokemonRequest) = pokemonApi.getPokemon(pokemonRequest.numberOfPokemon)
}