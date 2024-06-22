package com.arjun.data.remote.api

import com.arjun.data.remote.dto.DashboardDto
import com.arjun.data.remote.dto.RegimeDto
import retrofit2.http.GET

interface RestApi {

    @GET("dashboard")
    suspend fun getDashboard(): DashboardDto

    @GET("regime")
    suspend fun getRegime(): RegimeDto
}