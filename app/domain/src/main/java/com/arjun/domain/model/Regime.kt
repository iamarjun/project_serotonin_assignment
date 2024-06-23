package com.arjun.domain.model

data class Regime(
    val items: List<ItemsToConsume>
)

data class ItemsToConsume(
    val title: String,
    val products: List<Product>
)
