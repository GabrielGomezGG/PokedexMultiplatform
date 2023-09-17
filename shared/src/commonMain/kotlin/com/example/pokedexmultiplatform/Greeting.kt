package com.example.pokedexmultiplatform

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Greeting {

    private val client = HttpClient(){
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun greeting() : List<Post>{
        val response = client.get("https://jsonplaceholder.typicode.com/todos/")
        return response.body<List<Post>>()
    }
}