package com.konradgroup.nav3demo.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.konradgroup.nav3demo.ui.favorites.favoritesEntries
import com.konradgroup.nav3demo.ui.pokemons.pokemonEntries
import com.konradgroup.nav3demo.ui.settings.settingsEntries

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
    val entryProvider = entryProvider {
        pokemonEntries(
            onSubRouteClick = { navigator.navigate(it) },
            navigateBack = navigator::goBack,
            resultStore = resultStore
        )
        favoritesEntries()
        settingsEntries(
            onSubRouteClick = { navigator.navigate(it) },
            navigateBack = navigator::goBack,
        )
    }
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
            entries = navigationState.toEntries(entryProvider)
        )
    }
}
