package com.example.machinetestnewage.presentation.planetaryDetails

import com.example.machinetestnewage.domain.model.PlanetaryData

data class PlanetaryDetailsState(
    val success: PlanetaryData? = null,
    val error: String = "",
    val loading: Boolean = false
)