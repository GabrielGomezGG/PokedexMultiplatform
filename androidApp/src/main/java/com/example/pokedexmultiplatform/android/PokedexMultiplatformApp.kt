package com.example.pokedexmultiplatform.android

import android.app.Application
import com.example.pokedexmultiplatform.android.di.androidModule
import com.example.pokedexmultiplatform.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexMultiplatformApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokedexMultiplatformApp)

            modules(appModule() + androidModule())
        }
    }
}