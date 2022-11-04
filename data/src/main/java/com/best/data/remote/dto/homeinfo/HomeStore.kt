package com.best.data.remote.dto.homeinfo

import com.google.gson.annotations.SerializedName

internal data class HomeStore(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_new") var isNew: Boolean? = null,
    @SerializedName("title") var title: String = "",
    @SerializedName("subtitle") var subtitle: String ="",
    @SerializedName("picture") var picture: String = "",
    @SerializedName("is_buy") var isBuy: Boolean? = null

)
