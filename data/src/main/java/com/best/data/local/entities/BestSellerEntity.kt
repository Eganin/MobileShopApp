package com.best.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BestSellerEntity(
    @PrimaryKey
    val id: Int?=null,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)
