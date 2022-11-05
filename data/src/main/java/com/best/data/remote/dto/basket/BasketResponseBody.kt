package com.best.data.remote.dto.basket

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class BasketResponseBody(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("images") var images: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("title") var title: String? = null
)
