package com.konradgroup.nav3demo.ui.pokemons.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.konradgroup.nav3demo.ui.navigation.ResultStore

@Composable
fun PokemonFiltersScreen(
    onNavigateBack: () -> Unit,
    onFilterSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonFiltersViewModel = viewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.events.collect {event ->
            when(event) {
                is PokemonFiltersEvent.NavigateToPokemons -> onFilterSelected(event.filter)
                is PokemonFiltersEvent.NavigateBack -> onNavigateBack()
            }
        }
    }
    Content(
        filters = uiState.filters,
        modifier = modifier.background(MaterialTheme.colorScheme.background).padding(16.dp),
        onNavigateBack = {
            viewModel.onIntent(PokemonFiltersIntent.OnBackClicked) 
        },
        onFilterSelected = {
            viewModel.onIntent(PokemonFiltersIntent.OnFilterSelected(it)) 
        },
    )
}

@Composable
private fun Content(
    filters: Set<String>,
    onNavigateBack: () -> Unit,
    onFilterSelected: (String) -> Unit,
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

        filters.toList().chunked(4).forEach { rowFilters ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowFilters.forEach { filter ->
                    Button(
                        onClick = { onFilterSelected(filter) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = filter)
                    }
                }
                // Fill the remaining space in the row if there are fewer than 4 buttons
                repeat(4 - rowFilters.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
