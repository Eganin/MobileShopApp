package com.best.data.datasource.local

import com.best.domain.models.BestSellerProduct
import com.best.domain.models.HomeOtherInfo
import com.best.domain.models.ProductBasketInfo

interface LocalDataSource {

    suspend fun getHomeOtherInfo():HomeOtherInfo

    suspend fun getBasket():List<ProductBasketInfo>

    suspend fun updateBasket(productBasketInfo: ProductBasketInfo)

    suspend fun updateFavoriteProduct(favoriteProduct: BestSellerProduct)

    suspend fun getAllFavoriteProducts():List<BestSellerProduct>
}