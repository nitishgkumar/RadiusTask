package com.example.radiustask.propertyFilterByFacilities.data.remote

import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FilterListDTO
import com.example.radiustask.propertyFilterByFacilities.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServiceHelper {

    @GET(ApiEndPoint.FACILITIES_URL)
    suspend fun getList(
    ): Flow<Resource<FilterListDTO>>


}