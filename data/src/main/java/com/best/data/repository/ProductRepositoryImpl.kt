package com.best.data.repository

import com.best.data.datasource.local.LocalDataSource
import com.best.data.datasource.remote.RemoteDataSource
import com.best.data.mapper.toBestSellerProduct
import com.best.data.mapper.toProduct
import com.best.data.util.DefaultDispatchers
import com.best.domain.models.AllHomeInfo
import com.best.domain.models.BestSellerProduct
import com.best.domain.models.DetailProduct
import com.best.domain.models.ProductBasketInfo
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val defaultDispatchers: DefaultDispatchers
) : ProductRepository {
    override fun fetchHomeInfo(): Flow<Resource<AllHomeInfo>> {
        return flow {
            bodyForDataLoading(defaultDispatchers) {
                val info = remoteDataSource.getHomeInfo()
                AllHomeInfo(
                    otherInfo = localDataSource.getHomeOtherInfo(),
                    homeStore = info.homeStore.map { it.toProduct() },
                    bestSeller = info.bestSeller.map { it.toBestSellerProduct() }
                )
            }
        }
    }

    override fun fetchBasketForUser(): Flow<Resource<List<ProductBasketInfo>>> {
        return flow {
            bodyForDataLoading(defaultDispatchers) {
                val result = mutableListOf<ProductBasketInfo>().also {
                    it.addAll(remoteDataSource.getBasketResponse())
                    it.addAll(localDataSource.getBasket())
                }.toSet().toList()
                result
            }
        }
    }

    override fun fetchDetailInfoProduct(): Flow<Resource<DetailProduct>> {
        return flow {
            bodyForDataLoading(defaultDispatchers) {
                remoteDataSource.getDetailInfoProduct()
            }
        }
    }

    override fun fetchAllFavouriteProducts(): Flow<Resource<List<BestSellerProduct>>> {
        return flow {
            bodyForDataLoading(defaultDispatchers) {
                localDataSource.getAllFavoriteProducts()
            }
        }
    }

    override suspend fun updateBasket(productBasketInfo: ProductBasketInfo) {
        withContext(defaultDispatchers.io()) {
            localDataSource.updateBasket(productBasketInfo = productBasketInfo)
        }
    }

    override suspend fun updateFavoriteProduct(bestSellerProduct: BestSellerProduct) {
        withContext(defaultDispatchers.io()) {
            localDataSource.updateFavoriteProduct(favoriteProduct = bestSellerProduct)
        }
    }
}