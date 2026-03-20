package com.konradgroup.nav3demo.ui.pokemons.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konradgroup.nav3demo.data.PokemonRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonFiltersViewModel(
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(FilterUIState())
    val state = _state.asStateFlow()

    private val _events = MutableSharedFlow<PokemonFiltersEvent>()
    val events = _events.asSharedFlow()

    init {
        onIntent(PokemonFiltersIntent.LoadFilters)
    }

    fun onIntent(intent: PokemonFiltersIntent) {
        when (intent) {
            is PokemonFiltersIntent.LoadFilters -> loadFilters()
            is PokemonFiltersIntent.OnFilterSelected -> onFilterSelected(intent.filter)
            is PokemonFiltersIntent.OnBackClicked -> onBackClicked()
        }
    }

    private fun loadFilters() {
        viewModelScope.launch {
            val filters = repository.getPokemonTypes()
            _state.update { it.copy(filters = filters) }
        }
    }

    private fun onFilterSelected(filter: String) {
        viewModelScope.launch {
            _events.emit(PokemonFiltersEvent.NavigateToPokemons(filter))
        }
    }

    private fun onBackClicked() {
        viewModelScope.launch {
            _events.emit(PokemonFiltersEvent.NavigateBack)
        }
    }

}

sealed interface PokemonFiltersIntent {
    data object LoadFilters : PokemonFiltersIntent
    data class OnFilterSelected(val filter: String) : PokemonFiltersIntent
    data object OnBackClicked : PokemonFiltersIntent
}

sealed interface PokemonFiltersEvent {
    data object NavigateBack : PokemonFiltersEvent
    data class NavigateToPokemons(val filter: String) : PokemonFiltersEvent
}

data class FilterUIState(
    val filters: Set<String> = emptySet()
)