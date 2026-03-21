package com.konradgroup.nav3demo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon: ImageVector,
    val title: String,
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    Route.PokemonList to BottomNavItem(
        icon = Icons.Outlined.Home,
        title = "Pokemons"
    ),
    Route.PokemonFavorites to BottomNavItem(
        icon = Icons.Outlined.Favorite,
        title = "Favorites"
    ),
    Route.PokemonList to BottomNavItem(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    ),
)
