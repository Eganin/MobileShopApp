package com.best.domain.usecase

import com.best.domain.models.BestSellerProduct
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetFavoriteProducts(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<BestSellerProduct>>> {
        return repository.fetchAllFavouriteProducts()
    }
}