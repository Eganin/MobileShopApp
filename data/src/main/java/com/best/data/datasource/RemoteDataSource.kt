package com.best.data.datasource

import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.HomeInfo

internal interface RemoteDataSource :DataSource {
    suspend fun getHomeInfo():HomeInfo
    suspend fun getDetailInfoProduct():DetailInfoProduct
}