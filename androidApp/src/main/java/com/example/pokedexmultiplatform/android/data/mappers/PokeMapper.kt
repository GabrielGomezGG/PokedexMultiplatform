package com.example.pokedexmultiplatform.android.data.mappers

import com.example.pokedexmultiplatform.android.data.api.response.PokedexResults
import com.example.pokedexmultiplatform.android.domain.models.Pokemon


fun PokedexResults.toPokemon() : Pokemon {
    return Pokemon(name, url)
}