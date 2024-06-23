package com.arjun.domain.repository

import com.arjun.domain.model.Dashboard
import com.arjun.domain.model.Regime

interface ProjectSerotoninRepository {

    suspend fun getDashboard(): Dashboard

    suspend fun getRegime(): Regime
}