package com.best.data.mapper

import com.best.data.local.entities.BestSellerEntity
import com.best.domain.models.BestSellerProduct

fun BestSellerEntity.toFavoriteProduct(): BestSellerProduct {
    return BestSellerProduct(
        id = id ?: 0,
        isFavorites = isFavorites,
        title = title,
        priceWithoutDiscount = priceWithoutDiscount,
        discountPrice = discountPrice,
        picture = picture
    )
}