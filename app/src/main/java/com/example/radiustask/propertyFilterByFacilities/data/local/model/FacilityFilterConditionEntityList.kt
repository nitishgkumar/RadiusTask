package com.example.radiustask.propertyFilterByFacilities.data.local.model

import io.realm.RealmList
import io.realm.RealmObject

open class FacilityFilterConditionEntityList(
    var facilityFilterConditionEntityList: RealmList<FacilityFilterConditionEntity> = RealmList<FacilityFilterConditionEntity>()
) : RealmObject() {
    constructor() : this(RealmList<FacilityFilterConditionEntity>())
}