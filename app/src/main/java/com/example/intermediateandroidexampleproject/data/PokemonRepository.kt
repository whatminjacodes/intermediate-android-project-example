package com.example.intermediateandroidexampleproject.data

class PokemonRepository(
    private val pokemonApi: NetworkApi
) {
    suspend fun getPokemon(pokemonRequest: PokemonRequest) = pokemonApi.getPokemon(pokemonRequest.numberOfPokemon)
}