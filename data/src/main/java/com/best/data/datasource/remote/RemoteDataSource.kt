package com.best.data.datasource.remote

import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.domain.models.DetailProduct
import com.best.domain.models.ProductBasketInfo

interface RemoteDataSource {
    suspend fun getHomeInfo():HomeInfo
    suspend fun getDetailInfoProduct(): DetailProduct
    suspend fun getBasketResponse():List<ProductBasketInfo>
}