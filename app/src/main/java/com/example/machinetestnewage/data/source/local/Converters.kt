package com.example.machinetestnewage.data.source.local

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class Converters {
    private val moshi: Moshi = Moshi.Builder().build()
    private val type: Type = Types.newParameterizedType(List::class.java, PlanetaryEntity::class.java)
    private val jsonAdapter: JsonAdapter<List<PlanetaryEntity>> = moshi.adapter(type)

    @TypeConverter
    fun fromString(value: String): List<PlanetaryEntity> {
        return jsonAdapter.fromJson(value) ?: emptyList()
    }

    @TypeConverter
    fun fromInfoType(type: List<PlanetaryEntity>): String {
        return jsonAdapter.toJson(type)
    }
}