package com.example.pokedexmultiplatform.data

import com.example.pokedexmultiplatform.data.api.PokedexService
import com.example.pokedexmultiplatform.domain.Pokemon

interface IPokedexRepository {

    suspend fun getPokedex(): List<Pokemon>
}

class PokedexRepository (
    private val pokedexService: PokedexService
) : IPokedexRepository{
    override suspend fun getPokedex(): List<Pokemon> {
        if(pokedexService.getPokedex().isEmpty()){
            return emptyList()
        }
        return pokedexService.getPokedex().map {
            Pokemon(it.name,it.url)
        }
    }

}