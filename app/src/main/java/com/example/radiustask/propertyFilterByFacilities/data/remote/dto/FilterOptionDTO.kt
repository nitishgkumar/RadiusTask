package com.example.radiustask.propertyFilterByFacilities.data.remote.dto

import com.squareup.moshi.Json

data class FilterOptionDTO(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "icon") val icon: String?,
    @field:Json(name = "id") val id: Int?
)