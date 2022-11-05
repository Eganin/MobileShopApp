package com.best.data.mapper

import com.best.data.local.entities.BestSellerEntity
import com.best.domain.models.BestSellerProduct

fun BestSellerProduct.toBestSellerEntity(): BestSellerEntity {
    return BestSellerEntity(
        id = id,
        isFavorites = isFavorites,
        title = title,
        priceWithoutDiscount = priceWithoutDiscount,
        discountPrice = discountPrice,
        picture = picture
    )
}