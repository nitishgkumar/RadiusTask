package com.example.radiustask.propertyFilterByFacilities.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.FacilityOptionClickHandler
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.FilterOptionListAdapter
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model.FacilityOptionState

@BindingAdapter(value = ["setFilterOptions","filterOptionClickHandler"])
fun RecyclerView.setFilterOptions(
    filterOptions: List<FacilityOptionState>?, filterOptionClickHandler: FacilityOptionClickHandler
) {
    if (filterOptions != null) {
        val filterOptionListAdapter = FilterOptionListAdapter()
        filterOptionListAdapter.submitList(filterOptions)
        filterOptionListAdapter.filterOptionClickHandler = filterOptionClickHandler

        adapter = filterOptionListAdapter
    }
}