package com.example.pokedexmultiplatform.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexApi (
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
//    @SerialName("previous")
//    val previous: String,
    @SerialName("results")
    val results: List<PokemonApi>
)