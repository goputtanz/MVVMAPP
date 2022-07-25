package com.example.machinetestnewage.data.mapper

import com.example.machinetestnewage.data.source.local.PlanetaryEntity
import com.example.machinetestnewage.data.source.remote.dto.PlanetaryDataDtoItem
import com.example.machinetestnewage.domain.model.PlanetaryData

fun PlanetaryDataDtoItem.toPlanetaryEntity(): PlanetaryEntity {
    return PlanetaryEntity(
        date = date.toString(),
        explanation = explanation.toString(),
        hdurl = hdurl.toString(),
        title = title.toString(),
        url = url.toString()
    )
}

fun PlanetaryEntity.toData(): PlanetaryData {
    return PlanetaryData(
        date = date,
        explanation = explanation,
        hdurl = hdurl,
        title = title,
        url = url
    )
}