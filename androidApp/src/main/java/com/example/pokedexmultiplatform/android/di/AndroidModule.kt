package com.example.pokedexmultiplatform.android.di

import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun androidModule() = module {
    viewModel { PokedexViewModel(get()) }
}