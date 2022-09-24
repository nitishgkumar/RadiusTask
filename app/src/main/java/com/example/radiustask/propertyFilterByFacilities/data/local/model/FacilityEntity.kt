package com.example.radiustask.propertyFilterByFacilities.data.local.model

import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityOptionDTO
import com.squareup.moshi.Json
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class FacilityEntity(
    @PrimaryKey var facilityId: Int?, var name: String?, var options: RealmList<FacilityOptionEntity>?

) : RealmObject() {
    constructor() : this(0, "", RealmList<FacilityOptionEntity>())
}