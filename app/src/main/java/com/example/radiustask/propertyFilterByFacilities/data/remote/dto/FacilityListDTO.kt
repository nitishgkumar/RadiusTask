package com.example.radiustask.propertyFilterByFacilities.data.remote.dto

import com.squareup.moshi.Json

data class FacilityListDTO(
    @field:Json(name = "facilities") val facilities: List<FacilityDTO>?,
    @field:Json(name = "exclusions") val exclusions: List<List<FacilityFilterConditionDTO>>?
)

