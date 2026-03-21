package com.konradgroup.nav3demo.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object PokemonList : Route

    @Serializable
    data class PokemonDetail(val id: Int) : Route

    @Serializable
    data object PokemonFilters : Route

    @Serializable
    data object PokemonFavorites : Route

    @Serializable
    data object Settings : Route

    @Serializable
    data object Profile : Route
}
