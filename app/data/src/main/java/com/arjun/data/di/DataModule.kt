package com.arjun.data.di

import com.arjun.data.remote.api.RestApi
import com.arjun.data.repository.ProjectSerotoninRepositoryImpl
import com.arjun.domain.repository.ProjectSerotoninRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindProjectSerotoninRepositoryImpl(projectSerotoninRepositoryImpl: ProjectSerotoninRepositoryImpl): ProjectSerotoninRepository

    companion object {

        @Provides
        fun provideRestApi(): RestApi {
            return Retrofit.Builder()
                .baseUrl("https://api.project.serotonin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApi::class.java)
        }
    }
}