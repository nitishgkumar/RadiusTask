package com.example.radiustask.propertyFilterByFacilities.presentation.propertyFilter

import androidx.lifecycle.ViewModel
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.FacilityOptionClickHandler
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model.FacilityOptionState
import javax.inject.Inject

class PropertyFacilityViewModel @Inject constructor() : ViewModel(), FacilityOptionClickHandler {


    override fun onOptionSelection(filterOption: FacilityOptionState) {
   // when user click on the particular option
    }

}