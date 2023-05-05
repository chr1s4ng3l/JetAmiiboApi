package com.tamayo.jetamiiboapi.data.model


import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("amiibo")
    val amiibo: List<Amiibo>? = null
)