package com.example.pokedexmultiplatform.android.di

import com.example.pokedexmultiplatform.DatabaseDriverFactory
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun androidModule() = module {
    single { DatabaseDriverFactory(get()) }
    viewModel { PokedexViewModel(get()) }
}