package com.konradgroup.nav3demo.ui.pokemons.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokemonListScreen(
    onPokemonSelected: (Int) -> Unit,
    onFilterClicked: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = viewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is PokemonEvent.NavigateToPokemonDetail -> onPokemonSelected(event.id)
                is PokemonEvent.NavigateToFilters -> onFilterClicked()
            }
        }
    }
    Content(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        uiState = uiState,
        onPokemonSelected = { viewModel.onIntent(PokemonIntent.PokemonSelected(it)) },
        onFilterClicked = { viewModel.onIntent(PokemonIntent.FilterClicked) },
        onResetFilter = { viewModel.onIntent(PokemonIntent.ResetFilter) }
    )
}

@Composable
private fun Content(
    modifier: Modifier,
    uiState: PokemonUIState,
    onPokemonSelected: (Int) -> Unit,
    onFilterClicked: () -> Unit,
    onResetFilter: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (uiState.filter != null) {
                    Text(text = "Filter: ${uiState.filter}")
                    Button(onClick = onResetFilter) { Text(text = "Reset Filter") }
                }
            }
            Button(onClick = onFilterClicked) { Text(text = "Filters") }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = uiState.pokemons,
                key = { it.id },
            ) {
                PokemonCard(
                    pokemon = it,
                    onPokemonSelected = onPokemonSelected
                )
            }
        }
    }
}

@Composable
private fun PokemonCard(
    pokemon: PokemonUI,
    onPokemonSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onPokemonSelected(pokemon.id) },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = pokemon.id.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Text(text = pokemon.description)
    }
}
