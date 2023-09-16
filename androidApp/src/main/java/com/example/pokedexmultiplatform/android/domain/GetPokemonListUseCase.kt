package com.example.pokedexmultiplatform.android.domain


import com.example.pokedexmultiplatform.android.data.PokedexRepository
import com.example.pokedexmultiplatform.android.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokedexRepositoryImp: PokedexRepository
) {
    suspend operator fun invoke() : Flow<List<Pokemon>> {
        val pokemonList = flow {
            val pokemons = pokedexRepositoryImp.getPokedex() ?: emptyList()
            emit(pokemons)
        }
        return pokemonList
    }


}