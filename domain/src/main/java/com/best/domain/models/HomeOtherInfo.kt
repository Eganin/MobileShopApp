package com.best.domain.models

data class HomeOtherInfo(
    val geolocationName :String,
    val categories: List<String>,
    val brands:List<Brand>,
)
