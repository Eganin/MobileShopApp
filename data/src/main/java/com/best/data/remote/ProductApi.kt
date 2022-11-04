package com.best.data.remote

import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.HomeInfo
import retrofit2.http.GET

internal interface ProductApi {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeInfo(): List<HomeInfo>

    @GET("https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailInfoProduct():DetailInfoProduct
}