package com.example.radiustask.propertyFilterByFacilities.presentation.propertyFilter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiustask.propertyFilterByFacilities.domain.repository.PropertyFacilityRepo
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.FacilityOptionClickHandler
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model.FacilityOptionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyFacilityViewModel @Inject constructor(private val repository: PropertyFacilityRepo) : ViewModel(),
    FacilityOptionClickHandler {
    init {
        getDataForUI()
        getDataFromServer()

    }

    fun getDataForUI() {
        viewModelScope.launch {
            repository.getFacilityListForUI().collect {
                Log.d("getFacilityListForUI", it?.message ?: "" + it.data)
            }
        }
    }

    fun getDataFromServer() {
        viewModelScope.launch {
            repository.synFacilityListFromNetwork().collect {
                Log.d("getDataFromServer", it?.message ?: "" + it.data)
            }
        }
    }

    override fun onOptionSelection(filterOption: FacilityOptionState) {
        // when user click on the particular option
    }

}