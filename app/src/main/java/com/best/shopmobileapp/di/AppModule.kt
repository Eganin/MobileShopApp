package com.best.shopmobileapp.di

import com.best.domain.repository.ProductRepository
import com.best.domain.usecase.*
import com.best.domain.util.DefaultDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Singleton
    @Provides
    fun provideProductUseCases(
        productRepository: ProductRepository,
        defaultDispatchers: DefaultDispatchers
    ): ProductUseCases {
        return ProductUseCases(
            getHomeInfo = GetHomeInfo(repository = productRepository),
            getBasket = GetBasket(repository = productRepository),
            getDetailInfoForProduct = GetDetailInfoForProduct(repository = productRepository),
            getFavoriteProducts = GetFavoriteProducts(repository = productRepository),
            updateBasket = UpdateBasket(
                repository = productRepository,
                defaultDispatchers = defaultDispatchers
            ),
            updateFavoriteProduct = UpdateFavoriteProduct(
                repository = productRepository,
                defaultDispatchers = defaultDispatchers
            )
        )
    }
}