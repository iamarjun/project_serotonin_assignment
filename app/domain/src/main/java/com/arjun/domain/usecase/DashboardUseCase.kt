package com.arjun.domain.usecase

import com.arjun.domain.model.Dashboard
import com.arjun.domain.repository.ProjectSerotoninRepository
import javax.inject.Inject


class DashboardUseCase @Inject constructor(
    private val projectSerotoninRepository: ProjectSerotoninRepository
) {

    suspend operator fun invoke(): Dashboard
    {
        val data = projectSerotoninRepository.getDashboard()
        // perform operation on data, implement your business logics
        return data
    }
}