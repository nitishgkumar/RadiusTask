package com.example.radiustask.propertyFilterByFacilities.data.remote.dto

import com.squareup.moshi.Json

data class FilterDTO(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "facility_id") val facilityId: Int?,
    @field:Json(name = "options") val options: List<FilterOptionDTO>?
)