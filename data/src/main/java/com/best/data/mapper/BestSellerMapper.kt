package com.best.data.mapper

import com.best.data.remote.dto.homeinfo.BestSeller
import com.best.domain.models.BestSellerProduct

fun BestSeller.toBestSellerProduct(): BestSellerProduct {
    return BestSellerProduct(
        id = id ?: 0,
        isFavorites = isFavorites ?: false,
        title = title,
        priceWithoutDiscount = priceWithoutDiscount ?: 0,
        discountPrice = discountPrice ?: 0,
        picture = picture
    )
}