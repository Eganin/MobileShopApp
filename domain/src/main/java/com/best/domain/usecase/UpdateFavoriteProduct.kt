package com.best.domain.usecase

import com.best.domain.models.BestSellerProduct
import com.best.domain.repository.ProductRepository
import com.best.domain.util.DefaultDispatchers
import kotlinx.coroutines.withContext

class UpdateFavoriteProduct(
    private val repository: ProductRepository,
    private val defaultDispatchers: DefaultDispatchers
) {

    suspend operator fun invoke(bestSellerProduct: BestSellerProduct) {
        withContext(defaultDispatchers.io()) {
            repository.updateFavoriteProduct(bestSellerProduct = bestSellerProduct)
        }
    }
}