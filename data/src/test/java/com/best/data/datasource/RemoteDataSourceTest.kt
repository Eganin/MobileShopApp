package com.best.data.datasource

import com.best.data.BaseTest
import com.best.data.mapper.toDetailProduct
import com.best.data.remote.ProductApi
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.BestSeller
import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.data.remote.dto.homeinfo.HomeStore
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class RemoteDataSourceTest :BaseTest(){

    private lateinit var api: ProductApi
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        api = TestApi()
        remoteDataSource = RemoteDataSourceImpl(api = api)
    }

    @Test
    fun get_home_info() = runTest {
        assertThat(remoteDataSource.getHomeInfo()).isEqualTo(homeInfo)
    }

    @Test
    fun get_detail_info() = runTest {
        assertThat(remoteDataSource.getDetailInfoProduct()).isEqualTo(detailInfo.toDetailProduct())
    }
}