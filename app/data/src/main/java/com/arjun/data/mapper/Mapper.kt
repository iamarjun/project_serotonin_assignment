package com.arjun.data.mapper

import com.arjun.data.remote.dto.DashboardDto
import com.arjun.domain.model.Dashboard
import com.arjun.domain.model.Product


fun DashboardDto.toDashboard() = Dashboard(
    supplements = data?.today?.supplements?.all?.mapNotNull { it?.toProduct() } ?: emptyList(),
    addOns = data?.today?.userAddedSupplements?.mapNotNull { it?.toProduct() } ?: emptyList(),
)

fun DashboardDto.Data.Today.Supplements.All.toProduct() = Product(
    id = id ?: "",
    productId = productId ?: "",
    name = name ?: "",
    status = status ?: "",
    image = image ?: "",
    lastSyncedAt = lastSyncedAt ?: "",
    consumed = consumed ?: false,
    brand = brand ?: "",
)

fun DashboardDto.Data.Today.UserAddedSupplement.toProduct() = Product(
    id = id ?: "",
    productId = product?.id ?: "",
    name = product?.name ?: "",
    status = regimen?.status ?: "",
    image = product?.imageLink ?: "",
    lastSyncedAt = "",
    consumed = consumed ?: false,
    brand = product?.brand ?: "",
)