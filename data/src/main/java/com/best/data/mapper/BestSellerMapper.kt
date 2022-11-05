package com.best.data.mapper

import com.best.data.remote.dto.homeinfo.BestSeller
import com.best.domain.models.BestSellerProduct

fun BestSeller.toBestSellerProduct(): BestSellerProduct {
    return BestSellerProduct(
        id = id ,
        isFavorites = is_favorites,
        title = title,
        priceWithoutDiscount = price_without_discount,
        discountPrice = discount_price,
        picture = picture
    )
}