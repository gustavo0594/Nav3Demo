package com.konradgroup.nav3demo.ui.pokemons.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokemonDetailScreen(
    pokemonId: Int,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = viewModel {
        PokemonDetailViewModel(pokemonId)
    }
) {
    LaunchedEffect(Unit) {
        viewModel.events.collect {
            onNavigateBack()
        }
    }
    val uiState by viewModel.state.collectAsState()
    Content(
        modifier = modifier.fillMaxSize().padding(16.dp),
        pokemonDetailUI = uiState.pokemon,
        onNavigateBack = { viewModel.onIntent(PokemonDetailIntent.OnBackClicked) }
    )
}

@Composable
private fun Content(
    pokemonDetailUI: PokemonDetailUI,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Button(onClick = onNavigateBack) {
            Row {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                Text(text = "Back")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        with(pokemonDetailUI) {
            DetailRow(label = "ID", value = id.toString())
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Name", value = name)
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Height", value = "$height m")
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Weight", value = "$weight kg")
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Abilities", value = abilities.joinToString(" / "))
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Types", value = types.joinToString(" / "))
            Spacer(modifier = Modifier.height(16.dp))
            DetailRow(label = "Description", value = description)
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}