package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class HomeInfo(

    @SerializedName("home_store") var homeStore: List<HomeStore> = emptyList(),
    @SerializedName("best_seller") var bestSeller: List<BestSeller> = emptyList()

)
