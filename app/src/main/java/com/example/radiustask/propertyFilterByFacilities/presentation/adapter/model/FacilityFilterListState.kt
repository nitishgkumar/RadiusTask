package com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FacilityFilterListState(var id : Int ,var name: String, var options: List<FacilityOptionState>): Parcelable