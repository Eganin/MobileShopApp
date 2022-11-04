package com.best.domain.usecase

data class ProductUseCases(
    val getHomeInfo : GetHomeInfo,
    val getBasket: GetBasket,
    val getDetailInfoForProduct: GetDetailInfoForProduct,
    val updateBasket : UpdateBasket
)
