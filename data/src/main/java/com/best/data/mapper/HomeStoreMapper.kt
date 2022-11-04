package com.best.data.mapper

import com.best.data.remote.dto.homeinfo.HomeStore
import com.best.domain.models.Product

fun HomeStore.toProduct(): Product {
    return Product(
        id = id ?: 0,
        isNew = isNew ?: false,
        title = title,
        subtitle = subtitle,
        picture = picture,
        isBuy = isBuy ?: false
    )
}