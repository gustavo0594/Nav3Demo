package com.konradgroup.nav3demo.ui.pokemons.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konradgroup.nav3demo.data.PokemonRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {
    private val _state = MutableStateFlow(PokemonUIState())
    val state = _state.asStateFlow()

    private val _events = MutableSharedFlow<PokemonEvent>()
    val events = _events.asSharedFlow()

    init {
        onIntent(PokemonIntent.LoadPokemons)
    }


    fun onIntent(intent: PokemonIntent) {
        when (intent) {
            is PokemonIntent.LoadPokemons -> fetchPokemons()
            is PokemonIntent.PokemonSelected -> viewModelScope.launch {
                _events.emit(PokemonEvent.NavigateToPokemonDetail(intent.id))
            }

            is PokemonIntent.FilterClicked -> viewModelScope.launch {
                _events.emit(PokemonEvent.NavigateToFilters)
            }
        }
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            _state.update {
                val items = repository.getPokemons().map { pokemon ->
                    PokemonUI(
                        id = pokemon.id,
                        name = pokemon.name,
                        description = pokemon.description
                    )
                }
                it.copy(pokemons = items)
            }
        }
    }
}

sealed interface PokemonIntent {
    data object LoadPokemons : PokemonIntent
    data class PokemonSelected(val id: Int) : PokemonIntent
    data object FilterClicked : PokemonIntent
}

sealed interface PokemonEvent {
    data class NavigateToPokemonDetail(val id: Int) : PokemonEvent
    data object NavigateToFilters : PokemonEvent
}

data class PokemonUIState(
    val pokemons: List<PokemonUI> = emptyList()
)


data class PokemonUI(
    val id: Int,
    val name: String,
    val description: String,
)