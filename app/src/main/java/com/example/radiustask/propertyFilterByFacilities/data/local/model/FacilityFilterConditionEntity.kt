package com.example.radiustask.propertyFilterByFacilities.data.local.model

import io.realm.RealmObject

open class FacilityFilterConditionEntity(
    var facilityId: Int, var optionsId: Int
) : RealmObject() {
    constructor() : this(0, 0)
}