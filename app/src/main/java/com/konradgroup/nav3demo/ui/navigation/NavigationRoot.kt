package com.konradgroup.nav3demo.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.konradgroup.nav3demo.ui.navigation.decorators.rememberAnalyticsNavEntryDecorator
import com.konradgroup.nav3demo.ui.pokemons.detail.PokemonDetailScreen
import com.konradgroup.nav3demo.ui.pokemons.filters.PokemonFiltersScreen
import com.konradgroup.nav3demo.ui.pokemons.list.PokemonListScreen
import kotlin.collections.listOf

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(Route.PokemonList)
    val navigator = remember { Navigator(backStack) }
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()
    val dialogStrategy = DialogSceneStrategy<NavKey>()
    val combinedStrategy = dialogStrategy then listDetailStrategy
    val resultStore = rememberResultStore()
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = navigator::goBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberAnalyticsNavEntryDecorator()
        ),
        sceneStrategy = combinedStrategy,
        entryProvider = entryProvider {
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
                    onNavigateBack = {navigator.goBack() }
                )
            }
            entry<Route.PokemonFilters> {
                PokemonFiltersScreen(
                    onNavigateBack = { navigator.goBack() },
                    onFilterSelected = {
                        resultStore.setResult("pokemon-filter", it)
                        navigator.goBack()
                    }
                )
            }
        }
    )
}
