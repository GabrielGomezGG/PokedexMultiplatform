package com.example.pokedexmultiplatform.android.data


import com.example.pokedexmultiplatform.android.data.api.PokedexClient
import com.example.pokedexmultiplatform.android.data.mappers.toPokemon
import com.example.pokedexmultiplatform.android.domain.models.Pokemon
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(
    private val pokedexClient: PokedexClient
) : PokedexRepository {

    override suspend fun getPokedex(): List<Pokemon> {
        try{
            return pokedexClient.get().body()!!.results.map { it.toPokemon() }
        }catch (e : Exception){
            throw e
        }

    }
}