package com.example.pokedexmultiplatform.android.ui


import com.example.pokedexmultiplatform.android.domain.models.Pokemon
import com.example.pokedexmultiplatform.data.api.PokemonApi

sealed class PokedexUiState {
    object Loading : PokedexUiState()

    object Error : PokedexUiState()

    class Success(val pokemonList : List<PokemonApi>) : PokedexUiState()
//    class Success(val pokemonList : List<Pokemon>) : PokedexUiState()
}