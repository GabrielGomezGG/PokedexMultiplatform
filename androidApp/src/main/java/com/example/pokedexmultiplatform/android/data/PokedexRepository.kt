package com.example.pokedexmultiplatform.android.data

import com.example.pokedexmultiplatform.android.domain.models.Pokemon


interface PokedexRepository {

    suspend fun getPokedex() : List<Pokemon>?
}