package com.best.data

import com.best.data.local.dao.BestSellerDao
import com.best.data.local.dao.ProductInfoDao
import com.best.data.local.entities.BestSellerEntity
import com.best.data.local.entities.ProductInfoEntity
import com.best.data.remote.api.ProductApi
import com.best.data.remote.dto.basket.BasketResponse
import com.best.data.remote.dto.basket.BasketResponseBody
import com.best.data.remote.dto.detailinfo.DetailInfoProduct
import com.best.data.remote.dto.homeinfo.BestSeller
import com.best.data.remote.dto.homeinfo.HomeInfo
import com.best.data.remote.dto.homeinfo.HomeStore

internal open class BaseTest {

    val bestSellers = listOf(
        BestSellerEntity(
            id=1,
            isFavorites = true,
            title = "Iphone 15",
            priceWithoutDiscount = 5000,
            discountPrice = 0,
            picture = ""
        ),
        BestSellerEntity(
            id=2,
            isFavorites = true,
            title = "Pixel 10",
            priceWithoutDiscount = 3000,
            discountPrice = 100,
            picture = ""
        ),
    )

    val basketResponse = BasketResponse(
        basket = listOf(
            BasketResponseBody(
                id = 1,
                images = "https://",
                price = 1000,
                title = "Test"
            ),
            BasketResponseBody(
                id = 2,
                images = "https://",
                price = 2000,
                title = "Test Iphone 100"
            )
        ),
        delivery = "",
        id = "4",
        total = 2
    )

    val basketInfo = ProductInfoEntity(
        id = 0,
        title = "Samsung",
        price = 1000.0,
        imageLink = "https://",
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

    class BestSellerTestDao : BestSellerDao {

        private val listBestSellers = mutableListOf<BestSellerEntity>()

        override suspend fun insertBestSeller(bestSellerEntity: BestSellerEntity) {
            listBestSellers.add(bestSellerEntity)
        }

        override suspend fun clearBestSellerTable() {
            listBestSellers.clear()
        }

        override suspend fun getAllBestSellers(): List<BestSellerEntity> {
            return listBestSellers
        }
    }

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

        override suspend fun getBasketResponse(): BasketResponse {
            return BasketResponse(
                basket = listOf(
                    BasketResponseBody(
                        id = 1,
                        images = "https://",
                        price = 1000,
                        title = "Test"
                    ),
                    BasketResponseBody(
                        id = 2,
                        images = "https://",
                        price = 2000,
                        title = "Test Iphone 100"
                    )
                ),
                delivery = "",
                id = "4",
                total = 2
            )
        }
    }
}