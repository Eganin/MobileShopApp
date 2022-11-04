package com.best.data.datasource

import com.best.data.mapper.toDetailProduct
import com.best.data.remote.ProductApi
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.domain.models.DetailProduct
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val api : ProductApi
) : RemoteDataSource {
    override suspend fun getHomeInfo(): HomeInfo {
        return withContext(defaultDispatcher){
            api.getHomeInfo()
        }
    }

    override suspend fun getDetailInfoProduct(): DetailProduct {
        return withContext(defaultDispatcher){
            api.getDetailInfoProduct().toDetailProduct()
        }
    }
}