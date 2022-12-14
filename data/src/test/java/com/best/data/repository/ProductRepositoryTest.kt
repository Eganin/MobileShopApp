package com.best.data.repository

import com.best.data.BaseTest
import com.best.data.datasource.local.LocalDataSource
import com.best.data.datasource.local.LocalDataSourceImpl
import com.best.data.datasource.remote.RemoteDataSource
import com.best.data.datasource.remote.RemoteDataSourceImpl
import com.best.data.local.dao.BestSellerDao
import com.best.data.local.dao.ProductInfoDao
import com.best.data.mapper.*
import com.best.data.remote.api.ProductApi
import com.best.data.util.DefaultDispatchers
import com.best.domain.models.AllHomeInfo
import com.best.domain.models.ProductBasketInfo
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ProductRepositoryTest : BaseTest() {

    private lateinit var defaultDispatchers: DefaultDispatchers
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var localDataSource: LocalDataSource
    private lateinit var repository: ProductRepository
    private lateinit var api: ProductApi
    private lateinit var dao: ProductInfoDao
    private lateinit var bestSellerDao: BestSellerDao

    @Before
    fun setup() {
        api = TestApi()
        dao = TestDao()
        bestSellerDao = BestSellerTestDao()
        defaultDispatchers = DefaultDispatchers.Base()
        remoteDataSource = RemoteDataSourceImpl(api = api, defaultDispatchers)
        localDataSource = LocalDataSourceImpl(
            productInfoDao = dao,
            bestSellerDao = bestSellerDao,
            defaultDispatchers = defaultDispatchers
        )
        repository = ProductRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource,
            defaultDispatchers = defaultDispatchers
        )
    }

    @Test
    fun fetch_home_info() = runTest {
        repository.fetchHomeInfo().collect {
            if (it is Resource.Success) {
                it.data?.let { allHomeInfo ->
                    val otherInfo = localDataSource.getHomeOtherInfo()
                    assertThat(allHomeInfo).isEqualTo(
                        AllHomeInfo(
                            otherInfo = otherInfo,
                            homeStore = homeInfo.home_store.map { it.toProduct() },
                            bestSeller = homeInfo.best_seller.map { it.toBestSellerProduct() }
                        )
                    )
                }
            }
        }
    }

    @Test
    fun fetch_basket_for_user() = runTest {
        dao.insertProductInfo(basketInfo)
        repository.fetchBasketForUser().collect {
            if (it is Resource.Success) {
                it.data?.let { productBasketInfo ->
                    val expected = mutableListOf<ProductBasketInfo>().also {
                        it.addAll(basketResponse.basket.map { it.toProductBasketInfo() })
                        it.add(basketInfo.toProductBasketInfo())
                    }.toSet().toList()
                    assertThat(productBasketInfo).isEqualTo(expected)
                }
            }
        }
    }

    @Test
    fun fetch_detail_info_product() = runTest {
        repository.fetchDetailInfoProduct().collect {
            if (it is Resource.Success) {
                it.data?.let { detailProduct ->
                    assertThat(detailProduct).isEqualTo(detailInfo.toDetailProduct())
                }
            }
        }
    }

    @Test
    fun update_basket() = runTest {
        repository.updateBasket(productBasketInfo = basketInfo.toProductBasketInfo())
        assertThat(dao.getAllProductInfo()).isEqualTo(listOf(basketInfo))
    }

    @Test
    fun fetch_all_favourite_products_and_update_favourite_product() = runTest {
        repository.updateFavoriteProduct(
            bestSellerProduct = bestSellers.first().toFavoriteProduct()
        )
        repository.fetchAllFavouriteProducts().collect {
            if (it is Resource.Success) {
                it.data?.let { bestSellerProducts ->
                    assertThat(bestSellerProducts).isEqualTo(
                        listOf(
                            bestSellers.first().toFavoriteProduct()
                        )
                    )
                }
            }
        }
    }
}