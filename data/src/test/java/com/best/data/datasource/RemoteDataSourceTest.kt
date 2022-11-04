package com.best.data.datasource

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
internal class RemoteDataSourceTest {

    private lateinit var api: ProductApi
    private lateinit var remoteDataSource: RemoteDataSource

    val homeInfo = HomeInfo(
        homeStore = listOf(
            HomeStore(
                id = 0,
                isNew = true,
                title = "Iphone",
                subtitle = "12 pro max",
                picture = "",
                isBuy = true
            )
        ),
        bestSeller = listOf(
            BestSeller(
                id = 1,
                isFavorites = true,
                title = "Samsung",
                priceWithoutDiscount = 12,
                discountPrice = 0,
                picture = ""
            )
        )
    )

    val detailInfo = DetailInfoProduct(
        CPU = "nvidia",
        camera = "12px",
        price = 2000
    )

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
        assertThat(remoteDataSource.getDetailInfoProduct()).isEqualTo(detailInfo)
    }

    private class TestApi : ProductApi {
        override suspend fun getHomeInfo(): HomeInfo {
            return HomeInfo(
                homeStore = listOf(
                    HomeStore(
                        id = 0,
                        isNew = true,
                        title = "Iphone",
                        subtitle = "12 pro max",
                        picture = "",
                        isBuy = true
                    )
                ),
                bestSeller = listOf(
                    BestSeller(
                        id = 1,
                        isFavorites = true,
                        title = "Samsung",
                        priceWithoutDiscount = 12,
                        discountPrice = 0,
                        picture = ""
                    )
                )
            )
        }

        override suspend fun getDetailInfoProduct(): DetailInfoProduct {
            return DetailInfoProduct(
                CPU = "nvidia",
                camera = "12px",
                price = 2000
            )
        }
    }
}