package com.best.domain.usecase

import com.best.domain.models.ProductBasketInfo
import com.best.domain.repository.ProductRepository
import com.best.domain.util.DefaultDispatchers
import kotlinx.coroutines.withContext

class UpdateBasket(
    private val repository: ProductRepository,
    private val defaultDispatchers: DefaultDispatchers
) {
    suspend operator fun invoke(productBasketInfo: ProductBasketInfo) {
        withContext(defaultDispatchers.io()) {
            repository.updateBasket(productBasketInfo = productBasketInfo)
        }
    }
}