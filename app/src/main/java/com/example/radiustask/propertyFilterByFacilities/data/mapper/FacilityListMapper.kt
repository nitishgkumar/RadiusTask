package com.example.radiustask.propertyFilterByFacilities.data.mapper

import com.example.radiustask.propertyFilterByFacilities.data.local.model.FacilityEntity
import com.example.radiustask.propertyFilterByFacilities.data.local.model.FacilityFilterConditionEntity
import com.example.radiustask.propertyFilterByFacilities.data.local.model.FacilityListEntity
import com.example.radiustask.propertyFilterByFacilities.data.local.model.FacilityOptionEntity
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityFilterConditionDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityListDTO
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityOptionDTO


fun FacilityDTO.toFilterEntity(): FacilityEntity {
    val optionListEntity = options?.map {
        it.toFacilityOptionEntity()
    }
    return FacilityEntity(facilityId = facilityId, name = name, optionListEntity)
}


fun FacilityOptionDTO.toFacilityOptionEntity(): FacilityOptionEntity {

    return FacilityOptionEntity(name = name, icon = icon, id = id)
}


fun FacilityFilterConditionDTO.toFacilityFilterConditionEntity(): FacilityFilterConditionEntity {
    return FacilityFilterConditionEntity(facilityId = facilityId, optionsId = optionsId)
}


fun FacilityListDTO.toFilterListEntity(): List<FacilityEntity> {
    return facilities?.map {
        it.toFilterEntity()
    } ?: emptyList()
}


fun FacilityListDTO.toFilterListAndExclusionsListEntity(): FacilityListEntity {
    val facilityEntiitylist = toFilterListEntity()
    val exclusions = toFilterConditionListEntity()
    return FacilityListEntity(facilityEntiitylist, exclusions)
}

fun FacilityListDTO.toFilterConditionListEntity(): List<List<FacilityFilterConditionEntity>> {

    val exclusionsList = mutableListOf<List<FacilityFilterConditionEntity>>()
    var conditionList = mutableListOf<FacilityFilterConditionEntity>()
    exclusions?.map {
        conditionList = mutableListOf<FacilityFilterConditionEntity>()
        it.map {
            conditionList.add(FacilityFilterConditionEntity(it.facilityId, it.optionsId))
        }
        exclusionsList.add(conditionList)
    } ?: emptyList()

    return exclusionsList
}