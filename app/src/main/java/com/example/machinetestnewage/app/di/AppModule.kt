package com.example.machinetestnewage.app.di

import android.app.Application
import androidx.room.Room
import com.example.machinetestnewage.data.source.local.PlanetaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePlanetaryDatabase(application: Application) =
        Room.databaseBuilder(application, PlanetaryDatabase::class.java, "category_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePlanetaryDao(planetaryDatabase: PlanetaryDatabase) = planetaryDatabase.planetaryDao
}