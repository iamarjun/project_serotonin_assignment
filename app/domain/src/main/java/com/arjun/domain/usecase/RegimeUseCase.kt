package com.arjun.domain.usecase

import com.arjun.domain.model.Regime
import com.arjun.domain.repository.ProjectSerotoninRepository
import javax.inject.Inject


class RegimeUseCase @Inject constructor(
    private val projectSerotoninRepository: ProjectSerotoninRepository
) {

    suspend operator fun invoke(): Regime
    {
        val data = projectSerotoninRepository.getRegime()
        // perform operation on data, implement your business logics
        return data
    }
}