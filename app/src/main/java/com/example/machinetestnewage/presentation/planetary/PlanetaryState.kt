package com.example.machinetestnewage.presentation.planetary

import com.example.machinetestnewage.domain.model.PlanetaryData

data class PlanetaryState(
    val success: List<PlanetaryData> = emptyList(),
    val error: String = "",
    val loading: Boolean = false
)
