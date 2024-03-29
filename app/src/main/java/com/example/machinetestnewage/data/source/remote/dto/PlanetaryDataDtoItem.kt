package com.example.machinetestnewage.data.source.remote.dto


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@JsonClass(generateAdapter = true)
data class PlanetaryDataDtoItem(
    @Json(name = "copyright")
    val copyright: String?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "explanation")
    val explanation: String?,
    @Json(name = "hdurl")
    val hdurl: String?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "service_version")
    val serviceVersion: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "url")
    val url: String?
) : Parcelable