package com.example.radiustask.propertyFilterByFacilities.data.local.model

import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityOptionDTO
import com.squareup.moshi.Json
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class FacilityEntity(
    @PrimaryKey
    val facilityId: Int?,
    val name: String?,
    val options: List<FacilityOptionEntity>?

) : RealmObject()