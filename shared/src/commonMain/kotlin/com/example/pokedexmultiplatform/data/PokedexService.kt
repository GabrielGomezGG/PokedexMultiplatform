package com.example.pokedexmultiplatform.data

import com.example.pokedexmultiplatform.data.api.PokedexApi
import com.example.pokedexmultiplatform.data.api.PokemonApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokedexService {

    private val client = HttpClient(){
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getPokedex() : List<PokemonApi> {
        val response = client.get("https://pokeapi.co/api/v2/pokemon/?limit=800")
        return response.body<PokedexApi>().results
    }
}