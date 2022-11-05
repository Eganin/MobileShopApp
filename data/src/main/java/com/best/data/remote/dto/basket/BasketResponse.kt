package com.best.data.remote.dto.basket

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class BasketResponse(
    @SerializedName("basket") var basket: List<BasketResponseBody> = emptyList(),
    @SerializedName("delivery") var delivery: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("total") var total: Int? = null
)
