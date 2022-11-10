package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class BestSeller(

    @SerializedName("id") val id : Int,
    @SerializedName("is_favorites") val is_favorites : Boolean,
    @SerializedName("title") val title : String,
    @SerializedName("price_without_discount") val price_without_discount : Int,
    @SerializedName("discount_price") val discount_price : Int,
    @SerializedName("picture") val picture : String

)
