package com.arjun.domain.di

import com.arjun.domain.repository.ProjectSerotoninRepository
import com.arjun.domain.usecase.DashboardUseCase
import com.arjun.domain.usecase.RegimeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideDashboardUseCase(repository: ProjectSerotoninRepository): DashboardUseCase {
        return DashboardUseCase(repository)
    }

    @Provides
    fun provideRegimeUseCase(repository: ProjectSerotoninRepository): RegimeUseCase {
        return RegimeUseCase(repository)
    }
}