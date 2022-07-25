package com.example.machinetestnewage.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PlanetaryEntity::class], version = 1, exportSchema = false)
abstract class PlanetaryDatabase :RoomDatabase(){
    abstract val planetaryDao: PlanetaryDao
}