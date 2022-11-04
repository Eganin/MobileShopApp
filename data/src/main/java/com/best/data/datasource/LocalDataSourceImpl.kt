package com.best.data.datasource

import com.best.data.local.dto.ProductInfoDao
import com.best.data.mapper.toProductBasketInfo
import com.best.domain.models.Brand
import com.best.domain.models.HomeOtherInfo
import com.best.domain.models.ProductBasketInfo
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class LocalDataSourceImpl @Inject constructor(
    private val productInfoDao: ProductInfoDao
) : LocalDataSource {
    override suspend fun getHomeOtherInfo(): HomeOtherInfo {
        return HomeOtherInfo(
            geolocationName = "Zihuaatanejo, Gro",
            categories = listOf("phones", "computer", "Health", "Books"),
            brands = listOf(
                Brand(
                    name = "Samsung",
                    priceStart = 300.0,
                    priceEnd = 500.0,
                    size = "4.5 to 5.5 inches"
                ),
                Brand(
                    name = "Realme",
                    priceStart = 200.0,
                    priceEnd = 500.0,
                    size = "4.5 to 5.5 inches"
                )
            )
        )
    }

    override suspend fun getBasket(): List<ProductBasketInfo> {
        return withContext(defaultDispatcher) {
            productInfoDao.getAllProductInfo().map { it.toProductBasketInfo() }
        }
    }
}