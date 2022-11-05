package com.best.data.remote.api

import com.best.data.remote.dto.basket.BasketResponse
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.HomeInfo
import retrofit2.http.GET

interface ProductApi {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeInfo(): HomeInfo

    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailInfoProduct(): DetailInfoProduct

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getBasketResponse(): BasketResponse
}