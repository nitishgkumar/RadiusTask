package com.example.radiustask.propertyFilterByFacilities.data.local.model

import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityFilterConditionDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityOptionDTO
import com.squareup.moshi.Json
import io.realm.RealmList
import io.realm.RealmObject

class FacilityListEntity(

    val facilities: List<FacilityEntity>?,
     val exclusions: List<List<FacilityFilterConditionEntity>>?
) : RealmObject()