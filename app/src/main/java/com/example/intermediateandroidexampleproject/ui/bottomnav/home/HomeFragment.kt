package com.example.intermediateandroidexampleproject.ui.bottomnav.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.intermediateandroidexampleproject.data.PokemonList
import com.example.intermediateandroidexampleproject.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val pokemonListUpdatedObserver =
        Observer<List<PokemonList>> { listOfPokemon ->
            if (listOfPokemon != null) {
                binding.fragmentHomeText.text = listOfPokemon[0].name
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.listOfPokemon.observe(viewLifecycleOwner, pokemonListUpdatedObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getPokemon()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}