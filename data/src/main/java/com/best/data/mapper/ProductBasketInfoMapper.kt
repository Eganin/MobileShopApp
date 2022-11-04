package com.best.data.mapper

import com.best.data.local.entities.ProductInfoEntity
import com.best.domain.models.ProductBasketInfo

internal fun ProductBasketInfo.toProductInfoEntity(): ProductInfoEntity {
    return ProductInfoEntity(
        title = title,
        price = price,
        imageLink = imageLink,
        countProduct = countProduct
    )
}