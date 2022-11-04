package com.best.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductInfoEntity(
    @PrimaryKey
    val id : Int? =null,
    val title:String,
    val price:Double,
    val imageLink:String,
    val countProduct:Int,
)
