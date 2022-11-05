package com.best.domain.usecase

import com.best.domain.models.ProductBasketInfo
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetBasket(
    private val repository: ProductRepository
) {

    operator fun invoke() : Flow<Resource<List<ProductBasketInfo>>> {
        return repository.fetchBasketForUser()
    }
}