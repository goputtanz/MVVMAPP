package com.example.machinetestnewage.data.remote.service

import com.example.machinetestnewage.data.remote.dto.PlanetaryDataDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PlanetaryService {
    @GET("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10")
    suspend fun getPlanetaryData():ApiResponse<PlanetaryDataDto>
}