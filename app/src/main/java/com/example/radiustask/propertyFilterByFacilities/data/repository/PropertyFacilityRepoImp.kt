package com.example.radiustask.propertyFilterByFacilities.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import com.example.radiustask.propertyFilterByFacilities.data.local.model.FacilityListEntity
import com.example.radiustask.propertyFilterByFacilities.data.mapper.toFilterConditionListEntity
import com.example.radiustask.propertyFilterByFacilities.data.mapper.toFilterListAndExclusionsListEntity
import com.example.radiustask.propertyFilterByFacilities.data.mapper.toFilterListEntity
import com.example.radiustask.propertyFilterByFacilities.data.remote.NetworkServiceHelper
import com.example.radiustask.propertyFilterByFacilities.data.remote.dto.FacilityListDTO
import com.example.radiustask.propertyFilterByFacilities.domain.model.Facility
import com.example.radiustask.propertyFilterByFacilities.domain.model.FacilityOption
import com.example.radiustask.propertyFilterByFacilities.domain.model.FacilityOptionCondition
import com.example.radiustask.propertyFilterByFacilities.domain.repository.PropertyFacilityRepo
import com.example.radiustask.propertyFilterByFacilities.util.Resource
import io.realm.ImportFlag
import io.realm.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PropertyFacilityRepoImp @Inject constructor(
    private val api: NetworkServiceHelper,
    private val db: Realm,
    private val dataStore: DataStore<Preferences>,
) : PropertyFacilityRepo {


    var userPreferences = mutableListOf<FacilityOptionCondition>()

    override suspend fun getFacilityListForUI(): Flow<Resource<List<Facility>>> {

        val facilityListFlow = flow<Resource<List<Facility>>> {

            emit(Resource.Loading(false))
            val facilityListEntity: FacilityListEntity? = getFacilityListFromDB()
            if (facilityListEntity == null) {
                emit(Resource.Loading(false, "Getting From server"))
                synFacilityListFromNetwork()
            } else {



            }

        }

        return facilityListFlow
    }

    override suspend fun synFacilityListFromNetwork(): Flow<Resource<String>> = flow {
        emit(Resource.Loading(true))
        try {
            api.getList()

            api.getList().data?.let {
                saveFacilityListToDB(it)
            }

            emit(Resource.Success("Data Sync"))

        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))

        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            null
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
        }
    }

    fun saveFacilityListToDB(facilityListDTO: FacilityListDTO) {
        val listFilterListEntity = facilityListDTO.toFilterListAndExclusionsListEntity()
        db.beginTransaction()
        db.deleteAll()
        db.insertOrUpdate(listFilterListEntity)
        db.commitTransaction()
    }

    fun getFacilityListFromDB(): FacilityListEntity? {
        return db.where(FacilityListEntity::class.java).findFirst()
    }

    override suspend fun selectFacilityOption(facilityOptionCondition: FacilityOptionCondition): Flow<Resource<FacilityOptionCondition>> =
        flow {
            emit(Resource.Loading(true))

            userPreferences.add(facilityOptionCondition)
            emit(Resource.Success(facilityOptionCondition))

        }

    override suspend fun unSelectFacilityOption(facilityOptionCondition: FacilityOptionCondition): Flow<Resource<FacilityOptionCondition>> {


        return flow {
            emit(Resource.Loading(true))
            var found = false
            userPreferences.forEach {
                if ((it.facilityId == facilityOptionCondition.facilityId) && (it.optionsId == facilityOptionCondition.optionsId)) {
                    userPreferences.remove(it)
                    found = true

                }
            }
            emit(Resource.Success(facilityOptionCondition))

        }

    }


//    suspend fun getDataStoreForFacilityOptionCondition(facilityOptionCondition: FacilityOptionCondition): Flow<FacilityOptionCondition> =
//        dataStore.data.catch { exception ->
//            // dataStore.data throws an IOException when an error is encountered when reading data
//            if (exception is IOException) {
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }.map { preferences ->
//            // Get our show completed value, defaulting to false if not set:
//            val optionId = preferences[intPreferencesKey(facilityOptionCondition.facilityId.toString() )] ?: 0
//            FacilityOptionCondition(facilityOptionCondition.facilityId, optionId)
//        }
//
//
//
//    suspend fun getAllDataStoreForFacilityOptionCondition(facilityOptionCondition: FacilityOptionCondition): Flow<FacilityOptionCondition> =
//        dataStore.data.catch { exception ->
//            // dataStore.data throws an IOException when an error is encountered when reading data
//            if (exception is IOException) {
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }.map { preferences ->
//            preferences.asMap()
//
//
//            // Get our show completed value, defaulting to false if not set:
//            val optionId = preferences[intPreferencesKey(facilityOptionCondition.facilityId.toString() )] ?: 0
//            FacilityOptionCondition(facilityOptionCondition.facilityId, optionId)
//        }
//
//
//
//    suspend fun updateDataStoreForFacilityOptionCondition(facilityOptionCondition: FacilityOptionCondition) {
//        dataStore.edit { preferences ->
//            preferences[intPreferencesKey(facilityOptionCondition.facilityId.toString())] = facilityOptionCondition.optionsId
//        }
//    }


}