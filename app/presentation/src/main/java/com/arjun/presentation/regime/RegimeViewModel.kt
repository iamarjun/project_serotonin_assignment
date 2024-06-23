package com.arjun.presentation.regime


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arjun.domain.usecase.RegimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegimeDtoViewModel @Inject constructor(
    private val regimeDtoUseCase: RegimeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())

    suspend fun doRegimeDto() {
        // update ui state to loading
        try {
            regimeDtoUseCase()
            // prepare the data for ui layer
            // update ui state with data
        } catch (e: Exception) {
            // update  ui for error
        }
    }
}

data class State(
    val isLoading: Boolean = false,
    val error: String = ""
)
