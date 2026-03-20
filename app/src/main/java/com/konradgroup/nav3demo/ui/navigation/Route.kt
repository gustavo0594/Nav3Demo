package com.konradgroup.nav3demo.ui.navigation

sealed interface Route {

    data object PokemonList : Route

    data class PokemonDetail(val id: Int) : Route

    data object PokemonFilters : Route

}