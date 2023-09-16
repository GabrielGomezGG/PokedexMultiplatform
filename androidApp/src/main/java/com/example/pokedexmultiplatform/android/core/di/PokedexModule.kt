package com.example.pokedexmultiplatform.android.core.di

import com.example.pokedexmultiplatform.android.data.PokedexRepository
import com.example.pokedexmultiplatform.android.data.PokedexRepositoryImp
import com.example.pokedexmultiplatform.android.data.api.PokedexClient
import com.example.pokedexmultiplatform.android.domain.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokedexModule {

    @Provides
    @Singleton
    fun providePokedexRepositoy(pokedexClient: PokedexClient) : PokedexRepository {
        return PokedexRepositoryImp(pokedexClient)
    }

    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(pokedexRepository: PokedexRepository) : GetPokemonListUseCase {
        return GetPokemonListUseCase(pokedexRepository)
    }

}