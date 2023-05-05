package com.tamayo.jetamiiboapi.domain

import com.tamayo.jetamiiboapi.data.model.Amiibo
import com.tamayo.jetamiiboapi.data.model.Release

/**
 * @SerializedName("amiiboSeries")
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
 */

data class ItemsDomain(
    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val head: String,
    val image: String,
    val name: String,
    val release: Release,
    val tail: String,
    val type: String
    )


fun List<Amiibo>?.toDomain(): List<ItemsDomain> =
    this?.map {
        ItemsDomain(
            amiiboSeries = it.amiiboSeries ?: "",
            character = it.character ?: "",
            gameSeries = it.gameSeries ?: "",
            head = it.head ?: "",
            image = it.image ?: "",
            name = it.name ?: "",
            release = (it.release ?: Release(au = "", eu = "", jp = "", na = "")),
            tail = it.tail ?: "",
            type = it.type ?: ""

        )
    }?: emptyList()
