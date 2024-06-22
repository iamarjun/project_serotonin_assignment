package com.arjun.domain.repository

interface ProjectSerotoninRepository {

    suspend fun getDashboard()

    suspend fun getRegime()
}