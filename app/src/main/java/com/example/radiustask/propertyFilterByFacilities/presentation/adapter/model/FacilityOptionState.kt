package com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model

import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableWrapper
import android.os.Parcelable
import com.example.radiustask.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FacilityOptionState(
    var id: Int,
    var name: String = "Boat",
    var icon: Int = R.drawable.boat,
//    var selectionState: FacilityOptionSelectionState = FacilityOptionSelectionState.Unselected(),
    var selectionStyle: Int = R.style.Theme_FilterOptionUnSelected
) : Parcelable