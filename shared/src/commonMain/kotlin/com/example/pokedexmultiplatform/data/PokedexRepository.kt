package com.example.pokedexmultiplatform.data

import com.example.pokedexmultiplatform.DatabaseDriverFactory
import com.example.pokedexmultiplatform.MyDatabase
import com.example.pokedexmultiplatform.data.api.PokedexService
import com.example.pokedexmultiplatform.domain.models.Pokemon

interface IPokedexRepository {

    suspend fun getPokedex(): List<Pokemon>

    suspend fun getPokedexFromDB(): List<Pokemon>

    suspend fun insertPokemon(pokemon: Pokemon)

    suspend fun deletePokemon(pokemon: Pokemon)
}

class PokedexRepository (
    private val pokedexService: PokedexService,
    driverFactory: DatabaseDriverFactory
) : IPokedexRepository{

    private val database = MyDatabase(driverFactory.createDriver())
    private val dbQueries = database.pokemonQueries
    override suspend fun getPokedex(): List<Pokemon> {
        if(pokedexService.getPokedex().isEmpty()){
            return emptyList()
        }
        return pokedexService.getPokedex().map {
            Pokemon(it.name,it.url)
        }
    }

    override suspend fun getPokedexFromDB(): List<Pokemon> {
        return dbQueries.selectAllPokemon().executeAsList().map {
            Pokemon(it.name,it.url)
        }
    }

    override suspend fun insertPokemon(pokemon: Pokemon) {
        dbQueries.transaction {
            dbQueries.insertPokemon(pokemon.name,pokemon.url)
        }
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        dbQueries.deleteAllPokemon()
    }

}