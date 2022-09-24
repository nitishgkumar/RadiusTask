package com.example.radiustask.propertyFilterByFacilities.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.radiustask.databinding.FilterOptionListItemBinding
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.model.FacilityOptionState


class FilterOptionViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

class FilterOptionListAdapter : ListAdapter<FacilityOptionState, FilterOptionViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<FacilityOptionState>() {
        override fun areItemsTheSame(oldItem: FacilityOptionState, newItem: FacilityOptionState): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FacilityOptionState, newItem: FacilityOptionState): Boolean {
            return oldItem.selectionStyle == newItem.selectionStyle
        }
    }

    lateinit var filterOptionClickHandler: FacilityOptionClickHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterOptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilterOptionListItemBinding.inflate(inflater, parent, false)

        return FilterOptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterOptionViewHolder, position: Int) {
        val currentFacilityOptionState = getItem(position)
        val itemBinding = holder.binding as FilterOptionListItemBinding
        itemBinding.facilityOptionState = currentFacilityOptionState
        itemBinding.executePendingBindings()
        itemBinding.root.tag = currentFacilityOptionState
        itemBinding.root.setOnClickListener {
            val clickFacilityOptionState: FacilityOptionState = it.tag as FacilityOptionState
            filterOptionClickHandler. onOptionSelection(clickFacilityOptionState)
        }
    }
}