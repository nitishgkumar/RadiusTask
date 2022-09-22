package com.example.radiustask.propertyFilterByFacilities.data.remote

import com.squareup.moshi.Json

data class FilterConditionDTO(
    @field:Json(name = "facility_id") var facilityId: Int,
    @field:Json(name = "options_id") var optionsId: Int
)