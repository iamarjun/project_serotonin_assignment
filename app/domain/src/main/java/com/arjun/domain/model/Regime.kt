package com.arjun.domain.model

data class Regime(
    val items: List<ItemsToConsume>
)

data class ItemsToConsume(
    val code: String,
    val title: String,
    val products: List<Product>
)
