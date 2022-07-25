package com.example.machinetestnewage.data.repository

import com.example.machinetestnewage.app.di.Constants
import com.example.machinetestnewage.app.util.Resource
import com.example.machinetestnewage.data.mapper.toData
import com.example.machinetestnewage.data.mapper.toPlanetaryEntity
import com.example.machinetestnewage.data.source.local.PlanetaryDao
import com.example.machinetestnewage.data.source.remote.dto.PlanetaryDataDtoItem
import com.example.machinetestnewage.data.source.remote.service.PlanetaryService
import com.example.machinetestnewage.domain.model.PlanetaryData
import com.example.machinetestnewage.domain.repository.PlanetaryRepository
import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetaryRepositoryImpl @Inject constructor(
    private val planetaryService: PlanetaryService,
    private val planetaryDao: PlanetaryDao
    ) :PlanetaryRepository{

    override fun planetData(): Flow<Resource<List<PlanetaryData>>> = flow {
        emit(Resource.Loading)
        val data = fetchFromDatabase().first()
        val shouldFetch = planetaryDao.getDatabaseItems() == 0
        if (shouldFetch) {
            planetaryService.getPlanetaryData().suspendOnSuccess {
                saveCategories(this.data)
                emit(Resource.Success(fetchFromDatabase().first()))
            }.suspendOnError {
                when (statusCode) {
                    StatusCode.InternalServerError -> emit(Resource.Error(SERVER_ERROR))
                    else -> emit(Resource.Error(INTERNET_ERROR))
                }
            }.suspendOnException {
                emit(Resource.Error(this.message ?: UNKNOWN_ERROR))
            }
        } else {
            emit(Resource.Success(data))
        }
    }

    private fun fetchFromDatabase(): Flow<List<PlanetaryData>> {
        return planetaryDao.getPlanetaryData().map { it.map { planetaryEntity -> planetaryEntity.toData() } }
    }

    private suspend fun saveCategories(planetaryDataDtoItem: List<PlanetaryDataDtoItem>) {
        val planetaryEntities = planetaryDataDtoItem.map { it.toPlanetaryEntity() }
        planetaryDao.insertPlanetaryData(planetaryEntities)

    }


    companion object {
        const val SERVER_ERROR = "Server error"
        const val UNKNOWN_ERROR = "Unknown error"
        const val INTERNET_ERROR = "Error. Please check your internet connection and try again"

    }

}