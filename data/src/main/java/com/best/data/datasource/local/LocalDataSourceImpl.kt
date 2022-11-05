package com.best.data.datasource.local

import com.best.data.local.dao.ProductInfoDao
import com.best.data.mapper.toProductBasketInfo
import com.best.data.mapper.toProductInfoEntity
import com.best.data.util.DefaultDispatchers
import com.best.domain.models.Brand
import com.best.domain.models.HomeOtherInfo
import com.best.domain.models.ProductBasketInfo
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val productInfoDao: ProductInfoDao,
    private val defaultDispatchers: DefaultDispatchers
) : LocalDataSource {
    override suspend fun getHomeOtherInfo(): HomeOtherInfo {
        return HomeOtherInfo(
            geolocationName = "Zihuaatanejo, Gro",
            categories = listOf("Phones", "Computer", "Health", "Books"),
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
        return withContext(defaultDispatchers.io()) {
            productInfoDao.getAllProductInfo().map { it.toProductBasketInfo() }
        }
    }

    override suspend fun updateBasket(productBasketInfo: ProductBasketInfo) {
        withContext(defaultDispatchers.io()) {
            productInfoDao.insertProductInfo(productInfoEntity = productBasketInfo.toProductInfoEntity())
        }
    }
}