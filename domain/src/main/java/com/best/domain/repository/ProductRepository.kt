package com.best.domain.repository

import com.best.domain.models.AllHomeInfo
import com.best.domain.models.BestSellerProduct
import com.best.domain.models.DetailProduct
import com.best.domain.models.ProductBasketInfo
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun fetchHomeInfo(): Flow<Resource<AllHomeInfo>>

    fun fetchBasketForUser(): Flow<Resource<List<ProductBasketInfo>>>

    fun fetchDetailInfoProduct(): Flow<Resource<DetailProduct>>

    fun fetchAllFavouriteProducts(): Flow<Resource<List<BestSellerProduct>>>

    suspend fun updateBasket(productBasketInfo: ProductBasketInfo)

    suspend fun updateFavoriteProduct(bestSellerProduct: BestSellerProduct)
}