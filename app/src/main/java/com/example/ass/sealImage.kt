package com.example.ass

import com.google.gson.annotations.SerializedName
data class sealImage(
    @SerializedName("sealImageSeq") val sealImageSeq: String,
    @SerializedName("sealImage") val sealImage: String

)