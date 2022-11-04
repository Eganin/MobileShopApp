package com.best.data

import com.best.data.local.dto.ProductInfoDao
import com.best.data.local.entities.ProductInfoEntity
import com.best.data.remote.ProductApi
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.BestSeller
import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.data.remote.dto.homeinfo.HomeStore

internal open class BaseTest {

    val basketInfo=ProductInfoEntity(
        id = 0,
        title = "Samsung",
        price = 1000.0,
        imageLink = "https://",
        countProduct = 1,
    )

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

    class TestDao : ProductInfoDao {

        private val listProducts = mutableListOf<ProductInfoEntity>()

        override suspend fun insertProductInfo(productInfoEntity: ProductInfoEntity) {
            listProducts.add(productInfoEntity)
        }

        override suspend fun clearProductInfo() {
            listProducts.clear()
        }

        override suspend fun getAllProductInfo(): List<ProductInfoEntity> {
            return listProducts
        }
    }

    class TestApi : ProductApi {
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