package com.example.pokedexmultiplatform.domain

import com.example.pokedexmultiplatform.data.IPokedexRepository
import com.example.pokedexmultiplatform.domain.models.Pokemon

class GetAllPokemonUseCase(
    private val pokemonRepository: IPokedexRepository
) {
    suspend operator fun invoke():List<Pokemon> {

        if(pokemonRepository.getPokedexFromDB().isEmpty()){
            pokemonRepository.getPokedex().onEach {
                pokemonRepository.insertPokemon(it)
            }
        }

        return pokemonRepository.getPokedexFromDB()
    }
}