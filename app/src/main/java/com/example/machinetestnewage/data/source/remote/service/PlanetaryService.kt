package com.example.machinetestnewage.data.source.remote.service

import com.example.machinetestnewage.data.source.remote.dto.PlanetaryDataDtoItem
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PlanetaryService {
    @GET("apod?api_key=DEMO_KEY&count=10")
    suspend fun getPlanetaryData():ApiResponse<List<PlanetaryDataDtoItem>>
}