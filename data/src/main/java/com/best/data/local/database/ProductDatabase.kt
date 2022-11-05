package com.best.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.best.data.local.dao.BestSellerDao
import com.best.data.local.dao.ProductInfoDao
import com.best.data.local.entities.BestSellerEntity
import com.best.data.local.entities.ProductInfoEntity

@Database(
    entities = [
        ProductInfoEntity::class,BestSellerEntity::class
    ],
    version = 1
)
internal abstract class ProductDatabase : RoomDatabase(){

    abstract val productInfoDao : ProductInfoDao
    abstract val bestSellerDao : BestSellerDao

    companion object{
        const val NAME_DATABASE = "products.db"
    }
}