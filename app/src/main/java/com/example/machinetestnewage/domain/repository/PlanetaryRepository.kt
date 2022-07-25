package com.example.machinetestnewage.domain.repository

import com.example.machinetestnewage.app.util.Resource
import com.example.machinetestnewage.domain.model.PlanetaryData
import kotlinx.coroutines.flow.Flow


interface PlanetaryRepository {
    fun planetData(): Flow<Resource<List<PlanetaryData>>>
}