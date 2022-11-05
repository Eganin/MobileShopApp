package com.best.domain.usecase

import com.best.domain.models.DetailProduct
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetDetailInfoForProduct(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<Resource<DetailProduct>> {
        return repository.fetchDetailInfoProduct()
    }
}