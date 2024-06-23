package com.arjun.presentation.dashboard


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun.domain.model.Product
import com.arjun.domain.usecase.DashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardDtoViewModel @Inject constructor(
    private val dashboardDtoUseCase: DashboardUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getDashboardData()
    }

    private fun getDashboardData() {
        viewModelScope.launch {
            // update ui state to loading
            _state.value = State(isLoading = true)
            try {
                val response = dashboardDtoUseCase()
                // prepare the data for ui layer
                // update ui state with data
                _state.value = State(
                    supplements = response.supplements,
                    userAddedSupplement = response.addOns
                )
            } catch (e: Exception) {
                // update  ui for error
                _state.value = State(error = e.message ?: "Something went wrong")
            }
        }
    }
}

data class State(
    val isLoading: Boolean = false,
    val supplements: List<Product> = emptyList(),
    val userAddedSupplement: List<Product> = emptyList(),
    val error: String = ""
)
