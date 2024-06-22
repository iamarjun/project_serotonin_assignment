package com.arjun.presentation.dashboard


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arjun.domain.usecase.DashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardDtoViewModel @Inject constructor(
    private val dashboardDtoUseCase: DashboardUseCase
) : ViewModel() {

    suspend fun doDashboardDto() {
        // update ui state to loading
        try {
            dashboardDtoUseCase()
            // prepare the data for ui layer
            // update ui state with data
        } catch (e: Exception) {
            // update  ui for error
        }
    }
}

class DashboardDtoViewModelFactory(private val dashboardDtoUseCase: DashboardUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardDtoViewModel(dashboardDtoUseCase) as T
    }
}