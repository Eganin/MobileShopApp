package com.best.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.best.data.local.dto.ProductInfoDao
import com.best.data.local.entities.ProductInfoEntity

@Database(
    entities = [
        ProductInfoEntity::class
    ],
    version = 1
)
internal abstract class ProductDatabase : RoomDatabase(){

    abstract val productInfoDao : ProductInfoDao

    companion object{
        const val NAME_DATABASE = "products.db"
    }
}