package com.best.data.mapper

import com.best.data.remote.dto.basket.BasketResponseBody
import com.best.domain.models.ProductBasketInfo

fun BasketResponseBody.toProductBasketInfo(): ProductBasketInfo {
    return ProductBasketInfo(
        id = id ?: 0,
        title = title ?: "",
        price = price?.toDouble() ?: 0.0,
        imageLink = images ?: ""
    )
}