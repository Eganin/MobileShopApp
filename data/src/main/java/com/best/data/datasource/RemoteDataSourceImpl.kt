package com.best.data.datasource

import com.best.data.remote.ProductApi
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.HomeInfo
import kotlinx.coroutines.withContext

internal class RemoteDataSourceImpl(
    private val api : ProductApi
) : RemoteDataSource {
    override suspend fun getHomeInfo(): HomeInfo {
        return withContext(defaultDispatcher){
            api.getHomeInfo()
        }
    }

    override suspend fun getDetailInfoProduct(): DetailInfoProduct {
        return withContext(defaultDispatcher){
            api.getDetailInfoProduct()
        }
    }
}