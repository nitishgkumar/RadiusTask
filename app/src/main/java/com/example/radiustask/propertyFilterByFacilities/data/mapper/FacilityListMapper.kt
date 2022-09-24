package com.example.radiustask.propertyFilterByFacilities.data.mapper

import com.example.radiustask.propertyFilterByFacilities.data.local.model.*
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityFilterConditionDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityListDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityOptionDTO
import io.realm.RealmList


fun FacilityDTO.toFilterEntity(): FacilityEntity {
    val optionListEntity = RealmList<FacilityOptionEntity>()
    options?.forEach {
        optionListEntity.add(it.toFacilityOptionEntity())
    }
    return FacilityEntity(facilityId = facilityId, name = name, optionListEntity)
}


fun FacilityOptionDTO.toFacilityOptionEntity(): FacilityOptionEntity {

    return FacilityOptionEntity(name = name, icon = icon, id = id)
}


fun FacilityFilterConditionDTO.toFacilityFilterConditionEntity(): FacilityFilterConditionEntity {
    return FacilityFilterConditionEntity(facilityId = facilityId, optionsId = optionsId)
}


fun FacilityListDTO.toFilterListEntity(): RealmList<FacilityEntity> {
    val facilityEntityList = RealmList<FacilityEntity>()
    facilities?.forEach {
        facilityEntityList.add(it.toFilterEntity())
    }
    return facilityEntityList
}


fun FacilityListDTO.toFilterListAndExclusionsListEntity(): FacilityListEntity {
    val facilityEntiitylist = toFilterListEntity()
    val exclusions = toFilterConditionListEntity()
    return FacilityListEntity(facilityEntiitylist, exclusions)
}

fun FacilityListDTO.toFilterConditionListEntity(): RealmList<FacilityFilterConditionEntityList> {

    val exclusionsList = RealmList<FacilityFilterConditionEntityList>()
    var conditionList = FacilityFilterConditionEntityList()
    exclusions?.map {
        conditionList = FacilityFilterConditionEntityList()
        it.map {
            conditionList.facilityFilterConditionEntityList.add(
                FacilityFilterConditionEntity(
                    it.facilityId, it.optionsId
                )
            )
        }
        exclusionsList.add(conditionList)
    } ?: emptyList()

    return exclusionsList
}