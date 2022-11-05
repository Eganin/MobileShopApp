package com.best.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.best.data.local.entities.BestSellerEntity

@Dao
interface BestSellerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBestSeller(bestSellerEntity: BestSellerEntity)

    @Query("DELETE FROM bestsellerentity")
    suspend fun clearBestSellerTable()

    @Query("SELECT * FROM bestsellerentity")
    suspend fun getAllBestSellers(): List<BestSellerEntity>
}