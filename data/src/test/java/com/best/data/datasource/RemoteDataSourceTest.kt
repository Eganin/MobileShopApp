package com.best.data.datasource

import com.best.data.BaseTest
import com.best.data.datasource.remote.RemoteDataSource
import com.best.data.datasource.remote.RemoteDataSourceImpl
import com.best.data.mapper.toDetailProduct
import com.best.data.mapper.toProductBasketInfo
import com.best.data.remote.api.ProductApi
import com.best.data.util.DefaultDispatchers
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class RemoteDataSourceTest : BaseTest() {

    private lateinit var api: ProductApi
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        api = TestApi()
        remoteDataSource =
            RemoteDataSourceImpl(api = api, defaultDispatchers = DefaultDispatchers.Base())
    }

    @Test
    fun get_home_info() = runTest {
        assertThat(remoteDataSource.getHomeInfo()).isEqualTo(homeInfo)
    }

    @Test
    fun get_detail_info() = runTest {
        assertThat(remoteDataSource.getDetailInfoProduct()).isEqualTo(detailInfo.toDetailProduct())
    }

    @Test
    fun get_basket_response() = runTest {
        assertThat(remoteDataSource.getBasketResponse()).isEqualTo(
            basketResponse.basket.map { it.toProductBasketInfo() }
        )
    }
}