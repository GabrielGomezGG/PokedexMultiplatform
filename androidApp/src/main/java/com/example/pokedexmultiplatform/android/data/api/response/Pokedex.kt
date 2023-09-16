package com.example.pokedexmultiplatform.android.data.api.response

import com.google.gson.annotations.SerializedName

data class Pokedex(
    @SerializedName(value = "count")
    val count: Int,
    @SerializedName(value = "next")
    val next: String,
    @SerializedName(value = "previous")
    val previous: String,
    @SerializedName(value = "results")
    val results: List<PokedexResults>
)