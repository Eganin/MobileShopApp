package com.best.domain.usecase

import com.best.domain.models.AllHomeInfo
import com.best.domain.repository.ProductRepository
import com.best.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetHomeInfo(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<Resource<AllHomeInfo>>{
        return repository.fetchHomeInfo()
    }
}