package com.example.pokedexmultiplatform.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedexmultiplatform.android.R
import com.example.pokedexmultiplatform.android.domain.models.Pokemon
import com.example.pokedexmultiplatform.android.utils.ImageBuilder
import com.example.pokedexmultiplatform.data.api.PokemonApi


@Composable
fun MainScreen(pokedexViewModel: PokedexViewModel) {

    val response by pokedexViewModel.pokedex.collectAsState()
//    val example by pokedexViewModel.example.collectAsState()

//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//        LazyColumn(){
//            items(example){
//                Text(text = "ID: ${it.userId} - Title: ${it.title}")
//            }
//        }
//    }

    when (response) {
        PokedexUiState.Error -> TODO()
        PokedexUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is PokedexUiState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp)
            ) {
                items((response as PokedexUiState.Success).pokemonList){
                    PokemonCard(pokemon = it)
                }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: PokemonApi) {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Column(Modifier.padding(8.dp)) {
            Column {
                AsyncImage(
                    model = ImageBuilder.buildPokemonImageByUrl(pokemon.url),
                    contentDescription = pokemon.name,
                    placeholder = painterResource(id = R.drawable.pokeball),
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = pokemon.name,
                    Modifier
                        .fillMaxWidth(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}