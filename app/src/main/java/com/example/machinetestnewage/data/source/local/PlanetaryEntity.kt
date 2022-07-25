package com.example.machinetestnewage.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planetary_table")
data class PlanetaryEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val title: String,
    val url: String
)