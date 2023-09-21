package com.example.pokedexmultiplatform.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplatform.Greeting
import com.example.pokedexmultiplatform.Post
import com.example.pokedexmultiplatform.android.domain.GetPokemonListUseCase
import com.example.pokedexmultiplatform.data.PokedexService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokedex = MutableStateFlow<PokedexUiState>(PokedexUiState.Loading)
    val pokedex : StateFlow<PokedexUiState> = _pokedex.asStateFlow()

//    private val _example = MutableStateFlow<List<Post>>(emptyList())
//    val example : StateFlow<List<Post>> = _example.asStateFlow()

    init {
        getPokemonList()
        getExample()
    }

    private fun getPokemonList(){
//        viewModelScope.launch(Dispatchers.IO){
//            getPokemonListUseCase()
//                .catch { _pokedex.value = PokedexUiState.Error }
//                .collect{ _pokedex.value = PokedexUiState.Success(it)}
//        }
    }

    private fun getExample(){
        viewModelScope.launch {
//            _example.value = Greeting().greeting()
            val response = PokedexService().getPokedex()
            _pokedex.value = PokedexUiState.Success(response)
        }
    }
}
