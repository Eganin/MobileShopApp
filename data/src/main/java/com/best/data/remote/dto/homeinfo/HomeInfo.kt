package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class HomeInfo(

    @SerializedName("home_store") val home_store : List<HomeStore>,
    @SerializedName("best_seller") val best_seller : List<BestSeller>

)
