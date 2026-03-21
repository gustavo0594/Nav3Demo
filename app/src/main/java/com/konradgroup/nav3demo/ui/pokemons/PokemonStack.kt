package com.konradgroup.nav3demo.ui.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.scene.DialogSceneStrategy
import com.konradgroup.nav3demo.ui.navigation.ResultStore
import com.konradgroup.nav3demo.ui.navigation.Route
import com.konradgroup.nav3demo.ui.pokemons.detail.PokemonDetailScreen
import com.konradgroup.nav3demo.ui.pokemons.filters.PokemonFiltersScreen
import com.konradgroup.nav3demo.ui.pokemons.list.PokemonListScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun EntryProviderScope<NavKey>.pokemonEntries(
    onSubRouteClick: (navKey: NavKey) -> Unit,
    navigateBack: () -> Unit,
    resultStore: ResultStore
) {
    entry<Route.PokemonList>(
        metadata = ListDetailSceneStrategy.listPane(
            detailPlaceholder = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Detail placeholder")
                }
            }
        )
    ) {
        PokemonListScreen(
            onPokemonSelected = {
                onSubRouteClick(Route.PokemonDetail(it))
            },
            onFilterClicked = {
                onSubRouteClick(Route.PokemonFilters)
            },
            resultStore = resultStore
        )
    }
    entry<Route.PokemonDetail>(
        metadata = ListDetailSceneStrategy.detailPane()
    ) { key ->
        PokemonDetailScreen(
            pokemonId = key.id,
            onNavigateBack = navigateBack
        )
    }
    entry<Route.PokemonFilters> {
        PokemonFiltersScreen(
            onNavigateBack = navigateBack,
            onFilterSelected = {
                resultStore.setResult("pokemon-filter", it)
                navigateBack()
            }
        )
    }
}