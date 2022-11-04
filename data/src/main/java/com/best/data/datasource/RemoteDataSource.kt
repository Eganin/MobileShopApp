package com.best.data.datasource

import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.domain.models.DetailProduct

interface RemoteDataSource :DataSource {
    suspend fun getHomeInfo():HomeInfo
    suspend fun getDetailInfoProduct(): DetailProduct
}