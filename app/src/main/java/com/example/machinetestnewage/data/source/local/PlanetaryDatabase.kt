package com.example.machinetestnewage.data.source.local

import androidx.room.Database

@Database(entities = [PlanetaryEntity::class], version = 1, exportSchema = false)
abstract class PlanetaryDatabase {
    abstract val planetaryDao: PlanetaryDao
}