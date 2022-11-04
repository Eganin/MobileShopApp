package com.best.data.datasource

import com.best.domain.models.HomeOtherInfo
import com.best.domain.models.ProductBasketInfo

interface LocalDataSource : DataSource {

    suspend fun getHomeOtherInfo():HomeOtherInfo

    suspend fun getBasket():List<ProductBasketInfo>

    suspend fun updateBasket(productBasketInfo: ProductBasketInfo)
}