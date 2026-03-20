package com.konradgroup.nav3demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.konradgroup.nav3demo.ui.pokemons.detail.PokemonDetailScreen
import com.konradgroup.nav3demo.ui.pokemons.filters.PokemonFiltersScreen
import com.konradgroup.nav3demo.ui.pokemons.list.PokemonListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(Route.PokemonList)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.PokemonList> {
                PokemonListScreen(
                    onPokemonSelected = {
                        backStack.add(Route.PokemonDetail(it))
                    },
                    onFilterClicked = {
                        backStack.add(Route.PokemonFilters)
                    }
                )
            }
            entry<Route.PokemonDetail> { key ->
                PokemonDetailScreen(
                    pokemonId = key.id,
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Route.PokemonFilters> {
                PokemonFiltersScreen(
                    onNavigateBack = { backStack.removeLastOrNull() },
                    onFilterSelected = {}
                )
            }
        }
    )
}
