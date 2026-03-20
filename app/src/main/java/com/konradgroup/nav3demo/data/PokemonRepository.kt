package com.konradgroup.nav3demo.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(
    val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun getPokemons(): List<Pokemon> =
        withContext(dispatcher) { POKEMONS }

    suspend fun getPokemonById(id: Int): Pokemon =
        withContext(dispatcher) { POKEMONS.first { it.id == id } }

    suspend fun getPokemonTypes(): Set<String> =
        withContext(dispatcher) {
            POKEMONS.flatMap { it.types }
                .toSet()
        }

    suspend fun filterPokemonsByType(filter: String):List<Pokemon> =
        withContext(dispatcher) {
            POKEMONS.filter { it.types.contains(filter) }
        }

}
