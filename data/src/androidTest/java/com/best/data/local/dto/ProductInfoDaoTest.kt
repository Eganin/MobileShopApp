package com.best.data.local.dto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.best.data.local.database.ProductDatabase
import com.best.data.local.entities.ProductInfoEntity
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
internal class ProductInfoDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutor = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: ProductDatabase

    private lateinit var dao: ProductInfoDao

    private val insertEntity1 = ProductInfoEntity(
        id = 1,
        title = "Samsung",
        countProduct = 1,
        price = 300.0,
        imageLink = "https://google.com"
    )
    private val insertEntity2 = ProductInfoEntity(
        id = 2,
        title = "Realme",
        countProduct = 3,
        price = 250.0,
        imageLink = "https://google.com"
    )

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.productInfoDao
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertProduct() = runBlockingTest{
        dao.insertProductInfo(productInfoEntity = insertEntity1)
        dao.insertProductInfo(productInfoEntity = insertEntity2)
        val allItems = dao.getAllProductInfo()
        val expectedList = listOf(insertEntity1,insertEntity2)
        assertThat(allItems).isEqualTo(expectedList)
    }
}