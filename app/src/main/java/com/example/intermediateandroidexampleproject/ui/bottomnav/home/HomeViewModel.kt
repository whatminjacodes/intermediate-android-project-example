package com.example.intermediateandroidexampleproject.ui.bottomnav.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediateandroidexampleproject.data.PokemonList
import com.example.intermediateandroidexampleproject.data.PokemonRepository
import com.example.intermediateandroidexampleproject.data.PokemonRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
) : ViewModel() {

   // val listOfPokemon: MutableLiveData<List<PokemonList>> = MutableLiveData()

   /* fun getPokemon() {
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonResponse = pokemonRepository.getPokemon(PokemonRequest(10))

            withContext(Dispatchers.Main) {
                listOfPokemon.postValue(pokemonResponse.results)
            }
        }
    }*/
}