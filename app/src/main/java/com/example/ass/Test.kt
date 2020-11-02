package com.example.ass

import com.google.gson.annotations.SerializedName

class Test(
    @SerializedName("messageCode") val messageCode: String,
    @SerializedName("mobileNo") val mobileNo: String,
    @SerializedName("routeDate") val routeDate: String,
    @SerializedName("truckLicense") val truckLicense: String,
    @SerializedName("province") val province: String,
    @SerializedName("sealImage") val thumbnail: String,
    @SerializedName("sealImageList") val sealImageList: List<sealImage>

)