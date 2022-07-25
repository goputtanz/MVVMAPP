package com.example.machinetestnewage.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanetaryData(planetaryData : List<PlanetaryEntity>)

    @Query("SELECT * FROM planetary_table ORDER BY title")
    fun getPlanetaryData(): Flow<List<PlanetaryEntity>>

    @Query("SELECT COUNT(*) FROM planetary_table")
    fun getDatabaseItems(): Int
}