package com.best.domain.models

data class AllHomeInfo(
    val otherInfo: HomeOtherInfo,
    val homeStore: List<Product>,
    val bestSeller: List<BestSellerProduct>
)
