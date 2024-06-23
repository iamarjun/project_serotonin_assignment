package com.arjun.presentation.regime


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun.domain.model.Regime
import com.arjun.domain.usecase.RegimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegimeViewModel @Inject constructor(
    private val regimeDtoUseCase: RegimeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        doRegimeDto()
    }

    private fun doRegimeDto() {
        viewModelScope.launch {
            // update ui state to loading
            try {
                val response = regimeDtoUseCase()
                // update ui state to success
                // prepare the data for ui layer
                // update ui state with data
                _state.value = State(regime = response)
            } catch (e: Exception) {
                // update  ui for error
                _state.value = State(error = e.message ?: "An error occurred")
            }
        }
    }
}

data class State(
    val isLoading: Boolean = false,
    val regime: Regime? = null,
    val error: String = ""
)
