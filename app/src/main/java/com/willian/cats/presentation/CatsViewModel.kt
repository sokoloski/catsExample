package com.willian.cats.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willian.cats.domain.repository.CatsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatsViewModel(
    private val repository: CatsRepository
) : ViewModel() {

    private val cards = MutableLiveData<List<String>>()
    var job: Job? = null

    private val _state = MutableStateFlow<CatsState?>(CatsState(true))
    val state: StateFlow<CatsState?> get() = _state

    fun interact(interaction: CatsInteraction) {
        when (interaction) {
            is CatsInteraction.Open -> {
                fetchCardsResult()
            }
            is CatsInteraction.SearchCard-> {
                fetchResult()
            }
        }
    }

    private fun fetchResult() {
        viewModelScope.launch {
            _state.value = CatsState(false, listOf(), true)
        }
    }

    private fun fetchCardsResult() {
        viewModelScope.launch {
            job?.cancel()
            cards.value = repository.getCats()
            cards.value.let {
                _state.value = it?.let { cards -> CatsState(false, cards) }
            }
        }
    }
}
