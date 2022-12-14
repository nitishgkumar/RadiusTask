package com.example.radiustask.propertyFilterByFacilities.data.remote.dto

import com.squareup.moshi.Json

data class FacilityFilterConditionDTO(
    @field:Json(name = "facility_id") var facilityId: Int,
    @field:Json(name = "options_id") var optionsId: Int
)