package com.example.pokedexmultiplatform.android.ui


import com.example.pokedexmultiplatform.data.api.models.PokemonApi

sealed class PokedexUiState {
    object Loading : PokedexUiState()

    object Error : PokedexUiState()

    class Success(val pokemonList : List<PokemonApi>) : PokedexUiState()
}