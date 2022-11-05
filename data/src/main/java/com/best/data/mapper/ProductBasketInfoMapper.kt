package com.best.data.mapper

import com.best.data.local.entities.ProductInfoEntity
import com.best.domain.models.ProductBasketInfo

fun ProductBasketInfo.toProductInfoEntity(): ProductInfoEntity {
    return ProductInfoEntity(
        id=id,
        title = title,
        price = price,
        imageLink = imageLink,
    )
}