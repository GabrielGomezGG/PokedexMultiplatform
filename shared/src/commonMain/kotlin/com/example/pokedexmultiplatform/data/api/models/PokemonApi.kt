package com.example.pokedexmultiplatform.data.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonApi(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
