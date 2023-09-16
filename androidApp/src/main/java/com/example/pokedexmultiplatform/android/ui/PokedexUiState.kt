package com.example.pokedexmultiplatform.android.ui


import com.example.pokedexmultiplatform.android.domain.models.Pokemon

sealed class PokedexUiState {
    object Loading : PokedexUiState()

    object Error : PokedexUiState()

    class Success(val pokemonList : List<Pokemon>) : PokedexUiState()
}