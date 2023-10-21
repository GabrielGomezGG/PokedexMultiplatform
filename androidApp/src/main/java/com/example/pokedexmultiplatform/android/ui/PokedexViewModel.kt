package com.example.pokedexmultiplatform.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplatform.data.IPokedexRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokedexViewModel (
    private val pokedexRepository: IPokedexRepository
) : ViewModel() {

    private val _pokedex = MutableStateFlow<PokedexUiState>(PokedexUiState.Loading)
    val pokedex : StateFlow<PokedexUiState> = _pokedex.asStateFlow()

    init {
        getPokemonList()
    }



    private fun getPokemonList(){
        viewModelScope.launch {
            val response = pokedexRepository.getPokedex()
            _pokedex.value = PokedexUiState.Success(response)
        }
    }
}
