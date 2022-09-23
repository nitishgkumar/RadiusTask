package com.example.radiustask.propertyFilterByFacilities.presentation.propertyFilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radiustask.R
import com.example.radiustask.databinding.ActivityMainBinding
import com.example.radiustask.propertyFilterByFacilities.presentation.adapter.PropertyFilterListAdapter

class PropertyFacilityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: PropertyFacilityViewModel = hiltViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerViewNews = binding.filterRV
        val propertyFilterListAdapter = PropertyFilterListAdapter()
        propertyFilterListAdapter.filterOptionClickHandler = viewModel
        recyclerViewNews.adapter = propertyFilterListAdapter
        recyclerViewNews.layoutManager = LinearLayoutManager(this)
        recyclerViewNews.setHasFixedSize(true)
    }
}