package com.example.radiustask.propertyFilterByFacilities.data.local.model

import com.squareup.moshi.Json
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class FacilityOptionEntity(
    var name: String?, var icon: String?,  var id: Int?

) : RealmObject() {
    constructor() : this("", "", 0)
}