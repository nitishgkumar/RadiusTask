package com.example.radiustask.propertyFilterByFacilities.data.remote

import com.squareup.moshi.Json

data class FilterListDTO(
    @field:Json(name = "facilities") val facilities: List<FilterDTO>?,
    @field:Json(name = "exclusions") val exclusions: List<FilterConditionDTO>?
)

