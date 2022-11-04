package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

internal data class BestSeller(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_favorites") var isFavorites: Boolean? = null,
    @SerializedName("title") var title: String = "",
    @SerializedName("price_without_discount") var priceWithoutDiscount: Int? = null,
    @SerializedName("discount_price") var discountPrice: Int? = null,
    @SerializedName("picture") var picture: String = ""

)
