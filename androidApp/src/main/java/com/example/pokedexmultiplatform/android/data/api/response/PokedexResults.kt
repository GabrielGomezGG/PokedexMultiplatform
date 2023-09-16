package com.example.pokedexmultiplatform.android.data.api.response

import com.google.gson.annotations.SerializedName

data class PokedexResults(
    @SerializedName(value = "name")
    val name: String,
    @SerializedName(value = "url")
    val url: String
)
