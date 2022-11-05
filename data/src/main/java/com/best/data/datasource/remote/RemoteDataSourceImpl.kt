package com.best.data.datasource.remote

import com.best.data.mapper.toDetailProduct
import com.best.data.mapper.toProductBasketInfo
import com.best.data.remote.api.ProductApi
import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.data.util.DefaultDispatchers
import com.best.domain.models.DetailProduct
import com.best.domain.models.ProductBasketInfo
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val api: ProductApi,
    private val defaultDispatchers: DefaultDispatchers
) : RemoteDataSource {
    override suspend fun getHomeInfo(): HomeInfo {
        return withContext(defaultDispatchers.io()) {
            api.getHomeInfo()
        }
    }

    override suspend fun getDetailInfoProduct(): DetailProduct {
        return withContext(defaultDispatchers.io()) {
            api.getDetailInfoProduct().toDetailProduct()
        }
    }

    override suspend fun getBasketResponse(): List<ProductBasketInfo> {
        return withContext(defaultDispatchers.io()) {
            api.getBasketResponse().basket.map { it.toProductBasketInfo() }
        }
    }
}