package com.tamayo.jetamiiboapi.data.model


import com.google.gson.annotations.SerializedName

data class Amiibo(
    @SerializedName("amiiboSeries")
    val amiiboSeries: String? = null,
    @SerializedName("character")
    val character: String? = null,
    @SerializedName("gameSeries")
    val gameSeries: String? = null,
    @SerializedName("head")
    val head: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("release")
    val release: Release? = null,
    @SerializedName("tail")
    val tail: String? = null,
    @SerializedName("type")
    val type: String? = null
)