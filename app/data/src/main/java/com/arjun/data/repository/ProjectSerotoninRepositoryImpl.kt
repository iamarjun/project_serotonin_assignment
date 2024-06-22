package com.arjun.data.repository

import com.arjun.data.remote.api.RestApi
import com.arjun.domain.repository.ProjectSerotoninRepository
import javax.inject.Inject

class ProjectSerotoninRepositoryImpl @Inject constructor(
    private val restApi: RestApi
) : ProjectSerotoninRepository {
    override suspend fun getDashboard() {

    }

    override suspend fun getRegime() {

    }
}