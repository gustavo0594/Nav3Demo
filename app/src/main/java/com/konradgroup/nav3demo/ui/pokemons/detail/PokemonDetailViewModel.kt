package com.konradgroup.nav3demo.ui.pokemons.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konradgroup.nav3demo.data.PokemonRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    pokemonId: Int,
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailUIState())
    val state = _state.asStateFlow()

    private val _events = MutableSharedFlow<PokemonDetailEvent>()
    val events = _events.asSharedFlow()

    init {
        onIntent(PokemonDetailIntent.LoadPokemon(pokemonId))
    }

    fun onIntent(intent: PokemonDetailIntent) {
        when (intent) {
            is PokemonDetailIntent.LoadPokemon -> loadPokemon(intent.id)
            is PokemonDetailIntent.OnBackClicked -> viewModelScope.launch {
                _events.emit(PokemonDetailEvent.NavigateBack)
            }
        }
    }

    private fun loadPokemon(id: Int) {
        viewModelScope.launch {
            val pokemon = repository.getPokemonById(id)
            _state.update {
                it.copy(
                    pokemon = PokemonDetailUI(
                        id = pokemon.id,
                        name = pokemon.name,
                        description = pokemon.description,
                        weight = pokemon.weight,
                        height = pokemon.height,
                        abilities = pokemon.abilities,
                        types = pokemon.types
                    )
                )

            }
        }
    }

}

sealed interface PokemonDetailIntent {
    data class LoadPokemon(val id: Int) : PokemonDetailIntent
    data object OnBackClicked : PokemonDetailIntent
}

sealed interface PokemonDetailEvent {
    data object NavigateBack : PokemonDetailEvent
}


data class PokemonDetailUIState(
    val pokemon: PokemonDetailUI = PokemonDetailUI()
)

data class PokemonDetailUI(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val abilities: List<String> = emptyList(),
    val types: List<String> = emptyList(),
)

