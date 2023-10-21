package com.example.pokedexmultiplatform.di

import com.example.pokedexmultiplatform.data.IPokedexRepository
import com.example.pokedexmultiplatform.data.PokedexRepository
import com.example.pokedexmultiplatform.data.api.PokedexService
import org.koin.dsl.module

fun appModule() = module {
    single { PokedexService() }
    single<IPokedexRepository> { PokedexRepository(get()) }
}