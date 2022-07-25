package com.example.machinetestnewage.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class PlanetaryData(
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val title: String?,
    val url: String?
) : Parcelable
