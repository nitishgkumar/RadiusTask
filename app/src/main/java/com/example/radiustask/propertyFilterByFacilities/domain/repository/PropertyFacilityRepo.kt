package com.example.radiustask.propertyFilterByFacilities.domain.repository

import com.example.radiustask.propertyFilterByFacilities.domain.model.Facility
import com.example.radiustask.propertyFilterByFacilities.domain.model.FacilityOption
import com.example.radiustask.propertyFilterByFacilities.domain.model.FacilityOptionCondition
import com.example.radiustask.propertyFilterByFacilities.util.Resource
import kotlinx.coroutines.flow.Flow

interface PropertyFacilityRepo {

    suspend fun getFacilityListForUI(): Flow<Resource<List<Facility>>>
    suspend fun synFacilityListFromNetwork(): Flow<Resource<String>>

    suspend fun selectFacilityOption(facilityOptionCondition: FacilityOptionCondition): Flow<Resource<FacilityOptionCondition>>
    suspend fun unSelectFacilityOption(facilityOptionCondition: FacilityOptionCondition): Flow<Resource<FacilityOptionCondition>>

}