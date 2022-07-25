package com.example.machinetestnewage.app.di

import com.example.machinetestnewage.data.repository.PlanetaryRepositoryImpl
import com.example.machinetestnewage.domain.repository.PlanetaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PlanetaryModule {
    @Binds
    abstract fun bindPlanetaryRepository(planetaryRepositoryImpl: PlanetaryRepositoryImpl): PlanetaryRepository
}