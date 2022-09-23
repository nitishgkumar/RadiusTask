package com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model

import android.os.Parcelable
import com.example.radiustask.propertyFilterByFacilities.util.Resource
import kotlinx.android.parcel.Parcelize

@Suppress("PARCELABLE_PRIMARY_CONSTRUCTOR_IS_EMPTY")
@Parcelize
sealed class FacilityOptionSelectionState() : Parcelable {
    class Selected() : FacilityOptionSelectionState()
    class Unselected() : FacilityOptionSelectionState()
    class Disabled() : FacilityOptionSelectionState()
}