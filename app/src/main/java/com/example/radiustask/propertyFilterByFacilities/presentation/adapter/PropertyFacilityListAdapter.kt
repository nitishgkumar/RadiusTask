package com.example.radiustask.propertyFilterByFacilities.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.radiustask.databinding.FilterListItemBinding
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model.FacilityFilterListState


class PropertyFilterListViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

class PropertyFilterListAdapter : ListAdapter<FacilityFilterListState, PropertyFilterListViewHolder>(Companion) {
    private val viewPool = RecyclerView.RecycledViewPool()
    lateinit var filterOptionClickHandler: FacilityOptionClickHandler


    companion object : DiffUtil.ItemCallback<FacilityFilterListState>() {
        override fun areItemsTheSame(oldItem: FacilityFilterListState, newItem: FacilityFilterListState): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FacilityFilterListState, newItem: FacilityFilterListState): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyFilterListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilterListItemBinding.inflate(inflater, parent, false)

        return PropertyFilterListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyFilterListViewHolder, position: Int) {
        val currentBookCategory = getItem(position)
        val itemBinding = holder.binding as FilterListItemBinding

        itemBinding.facilityFilterListState = currentBookCategory
        itemBinding.filterOptionClickHandler = filterOptionClickHandler
        itemBinding.filterOptionItemListView.setRecycledViewPool(viewPool)

        itemBinding.executePendingBindings()
    }
}