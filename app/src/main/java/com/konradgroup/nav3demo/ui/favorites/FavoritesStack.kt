package com.konradgroup.nav3demo.ui.favorites

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.konradgroup.nav3demo.ui.navigation.Route

fun EntryProviderScope<NavKey>.favoritesEntries() {
    entry<Route.PokemonFavorites> {
        FavoritePokemonListScreen()
    }
}