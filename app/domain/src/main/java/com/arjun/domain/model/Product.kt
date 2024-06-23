package com.arjun.domain.model

data class Product(
    val id: String,
    val productId: String,
    val name: String,
    val status: String,
    val image: String,
    val lastSyncedAt: String,
    val consumed: Boolean,
    val brand: String,
)
