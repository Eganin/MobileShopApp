package com.best.data.mapper

import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.domain.models.DetailProduct

fun DetailInfoProduct.toDetailProduct(): DetailProduct {
    return DetailProduct(
        CPU = CPU,
        camera = camera,
        capacity = capacity,
        color = color,
        id = id ?: "0",
        images = images,
        isFavorites = isFavorites ?: false,
        price = price ?: 0,
        rating = rating ?: 0.0,
        sd = sd,
        ssd = ssd,
        title = title
    )
}