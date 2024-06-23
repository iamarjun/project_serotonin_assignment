package com.arjun.data.repository

import android.content.Context
import com.arjun.data.mapper.toDashboard
import com.arjun.data.mapper.toRegime
import com.arjun.data.remote.api.RestApi
import com.arjun.data.remote.dto.DashboardDto
import com.arjun.data.remote.dto.RegimeDto
import com.arjun.domain.model.Dashboard
import com.arjun.domain.model.Regime
import com.arjun.domain.repository.ProjectSerotoninRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProjectSerotoninRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val restApi: RestApi
) : ProjectSerotoninRepository {
    override suspend fun getDashboard(): Dashboard {
        // val response = restApi.getDashboard()
        val json = context.assets.open("dashboard.json").bufferedReader().use {
            it.readText()
        }

        val dashboard = Gson().fromJson(json, DashboardDto::class.java)

        return dashboard.toDashboard()
    }

    override suspend fun getRegime(): Regime {
        // val response = restApi.getRegime()
        val json = context.assets.open("regimen.json").bufferedReader().use {
            it.readText()
        }

        val regime = Gson().fromJson(json, RegimeDto::class.java)

        return regime.toRegime()
    }
}