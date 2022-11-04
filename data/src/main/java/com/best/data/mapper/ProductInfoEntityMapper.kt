package com.best.data.mapper

import com.best.data.local.entities.ProductInfoEntity
import com.best.domain.models.ProductBasketInfo

fun ProductInfoEntity.toProductBasketInfo(): ProductBasketInfo {
    return ProductBasketInfo(
        id=id?:0,
        title = title,
        price = price,
        imageLink = imageLink,
        countProduct = countProduct,
    )
}