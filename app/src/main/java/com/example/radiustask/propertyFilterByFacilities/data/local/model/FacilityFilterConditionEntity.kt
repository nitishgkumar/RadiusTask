package com.example.radiustask.propertyFilterByFacilities.data.local.model

import io.realm.RealmObject

data class FacilityFilterConditionEntity(
    var facilityId: Int, var optionsId: Int
) : RealmObject()