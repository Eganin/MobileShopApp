package com.best.data.remote.dto.detailinfo

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class DetailInfoProduct(
    @SerializedName("CPU") var CPU: String = "",
    @SerializedName("camera") var camera: String = "",
    @SerializedName("capacity") var capacity: List<String> = emptyList(),
    @SerializedName("color") var color: List<String> = emptyList(),
    @SerializedName("id") var id: String? = null,
    @SerializedName("images") var images: List<String> = emptyList(),
    @SerializedName("isFavorites") var isFavorites: Boolean? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("sd") var sd: String = "",
    @SerializedName("ssd") var ssd: String = "",
    @SerializedName("title") var title: String = ""
)
