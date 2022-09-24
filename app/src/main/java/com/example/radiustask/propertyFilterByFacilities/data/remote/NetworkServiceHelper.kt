package com.example.radiustask.propertyFilterByFacilities.data.remote

import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityListDTO
import com.example.radiustask.propertyFilterByFacilities.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface NetworkServiceHelper {

    @GET(ApiEndPoint.FACILITIES_URL)
    suspend fun getList(
    ): Resource<FacilityListDTO>


}