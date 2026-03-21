package com.konradgroup.nav3demo.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.konradgroup.nav3demo.ui.favorites.FavoritePokemonListScreen
import com.konradgroup.nav3demo.ui.pokemons.detail.PokemonDetailScreen
import com.konradgroup.nav3demo.ui.pokemons.filters.PokemonFiltersScreen
import com.konradgroup.nav3demo.ui.pokemons.list.PokemonListScreen
import com.konradgroup.nav3demo.ui.settings.SettingsScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val navigationState = rememberNavigationState(
        startRoute = Route.PokemonList,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember { Navigator(navigationState) }
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()
    val dialogStrategy = DialogSceneStrategy<NavKey>()
    val combinedStrategy = dialogStrategy then listDetailStrategy
    val resultStore = rememberResultStore()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            PokedexNavigationBar(
                selectedKey = navigationState.topLevelRoute,
                onSelectKey = { navigator.navigate(it) }
            )
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onBack = navigator::goBack,
            sceneStrategy = combinedStrategy,
            entries = navigationState.toEntries(
                entryProvider {
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
                                navigator.navigate(Route.PokemonDetail(it))
                            },
                            onFilterClicked = {
                                navigator.navigate(Route.PokemonFilters)
                            },
                            resultStore = resultStore
                        )
                    }
                    entry<Route.PokemonDetail>(
                        metadata = ListDetailSceneStrategy.detailPane()
                    ) { key ->
                        PokemonDetailScreen(
                            pokemonId = key.id,
                            onNavigateBack = { navigator.goBack() }
                        )
                    }
                    entry<Route.PokemonFilters>(
                        metadata = DialogSceneStrategy.dialog()
                    ) {
                        PokemonFiltersScreen(
                            onNavigateBack = { navigator.goBack() },
                            onFilterSelected = {
                                resultStore.setResult("pokemon-filter", it)
                                navigator.goBack()
                            }
                        )
                    }
                    entry<Route.PokemonFavorites> {
                        FavoritePokemonListScreen()
                    }
                    entry<Route.Settings> {
                        SettingsScreen()
                    }
                }
            )
        )
    }
}
