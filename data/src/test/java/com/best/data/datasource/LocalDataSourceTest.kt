package com.best.data.datasource

import com.best.data.BaseTest
import com.best.data.datasource.local.LocalDataSource
import com.best.data.datasource.local.LocalDataSourceImpl
import com.best.data.local.dao.ProductInfoDao
import com.best.data.local.entities.ProductInfoEntity
import com.best.data.mapper.toProductBasketInfo
import com.best.data.util.DefaultDispatchers
import com.best.domain.models.Brand
import com.best.domain.models.HomeOtherInfo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class LocalDataSourceTest : BaseTest() {

    private lateinit var localDataSource: LocalDataSource
    private lateinit var dao: ProductInfoDao

    @Before
    fun setup() {
        dao = TestDao()
        localDataSource = LocalDataSourceImpl(
            productInfoDao = dao,
            defaultDispatchers = DefaultDispatchers.Base()
        )
    }

    @Test
    fun test_get_basket_for_user() = runTest {
        dao.insertProductInfo(
            productInfoEntity = ProductInfoEntity(
                id = 0,
                title = "Samsung",
                price = 1000.0,
                imageLink = "https://"
            )
        )
        assertThat(localDataSource.getBasket()).isEqualTo(
            dao.getAllProductInfo().map { it.toProductBasketInfo() })
    }

    @Test
    fun test_get_home_other_info() = runTest {
        val info = HomeOtherInfo(
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
        assertThat(localDataSource.getHomeOtherInfo()).isEqualTo(info)
    }
}