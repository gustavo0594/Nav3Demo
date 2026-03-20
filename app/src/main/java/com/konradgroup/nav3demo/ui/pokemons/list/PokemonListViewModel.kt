package com.konradgroup.nav3demo.ui.pokemons.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konradgroup.nav3demo.data.Pokemon
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
            is PokemonIntent.FilterByType -> filterByType(intent.type)
            is PokemonIntent.PokemonSelected -> viewModelScope.launch {
                _events.emit(PokemonEvent.NavigateToPokemonDetail(intent.id))
            }

            is PokemonIntent.FilterClicked -> viewModelScope.launch {
                _events.emit(PokemonEvent.NavigateToFilters)
            }

            is PokemonIntent.ResetFilter -> fetchPokemons()
        }
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            val pokemons = repository.getPokemons()
            updateDataSource(pokemons)
        }
    }

    private fun filterByType(type: String) {
        viewModelScope.launch {
            val pokemons = repository.filterPokemonsByType(type)
            updateDataSource(pokemons = pokemons, filter = type)
        }
    }

    private fun updateDataSource(
        pokemons: List<Pokemon>,
        filter: String? = null
    ) {
        _state.update {
            val items = pokemons.map { pokemon ->
                PokemonUI(
                    id = pokemon.id,
                    name = pokemon.name,
                    description = pokemon.description
                )
            }
            it.copy(
                pokemons = items,
                filter = filter
            )
        }
    }
}

sealed interface PokemonIntent {
    data object LoadPokemons : PokemonIntent
    data class PokemonSelected(val id: Int) : PokemonIntent
    data object FilterClicked : PokemonIntent
    data class FilterByType(val type: String) : PokemonIntent
    data object ResetFilter : PokemonIntent
}

sealed interface PokemonEvent {
    data class NavigateToPokemonDetail(val id: Int) : PokemonEvent
    data object NavigateToFilters : PokemonEvent
}

data class PokemonUIState(
    val pokemons: List<PokemonUI> = emptyList(),
    val filter: String? = null
)


data class PokemonUI(
    val id: Int,
    val name: String,
    val description: String,
)