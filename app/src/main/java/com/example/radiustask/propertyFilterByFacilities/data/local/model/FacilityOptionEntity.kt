package com.example.radiustask.propertyFilterByFacilities.data.local.model

import com.squareup.moshi.Json
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
data class FacilityOptionEntity(
    val name: String?,
    val icon: String?,
    @PrimaryKey
    val id: Int?

) : RealmObject()