package com.best.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.best.data.local.database.ProductDatabase
import com.best.data.local.entities.BestSellerEntity
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
internal class BestSellerDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutor = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: ProductDatabase

    private lateinit var dao: BestSellerDao

    private val insertEntity1 = BestSellerEntity(
        id = 1,
        isFavorites = true,
        title = "Test",
        priceWithoutDiscount = 500,
        discountPrice = 100,
        picture = "https://"
    )

    private val insertEntity2 = BestSellerEntity(
        id = 2,
        isFavorites = true,
        title = "Test 2",
        priceWithoutDiscount = 600,
        discountPrice = 50,
        picture = "https://"
    )

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.bestSellerDao
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndGetBestSeller() = runTest {
        dao.insertBestSeller(bestSellerEntity = insertEntity1)
        dao.insertBestSeller(bestSellerEntity = insertEntity2)
        val allItems = dao.getAllBestSellers()
        val expected = listOf(insertEntity1, insertEntity2)
        assertThat(allItems).isEqualTo(expected)
    }

    @Test
    fun clearBestSeller() = runTest {
        dao.insertBestSeller(bestSellerEntity = insertEntity1)
        dao.insertBestSeller(bestSellerEntity = insertEntity2)
        val allItems = dao.getAllBestSellers()
        val expected = listOf(insertEntity1, insertEntity2)
        assertThat(allItems).isEqualTo(expected)
        dao.clearBestSellerTable()
        assertThat(dao.getAllBestSellers()).isEmpty()
    }
}