package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class HomeStore(

    @SerializedName("id") val id : Int,
    @SerializedName("is_new") var is_new : Boolean?=null,
    @SerializedName("title") val title : String,
    @SerializedName("subtitle") val subtitle : String,
    @SerializedName("picture") val picture : String,
    @SerializedName("is_buy") val is_buy : Boolean

)
