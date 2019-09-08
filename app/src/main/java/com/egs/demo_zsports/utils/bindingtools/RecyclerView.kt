package com.egs.demo_zsports.utils.bindingtools

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egs.demo_zsports.adapter.ItemAthleteAdapter
import com.egs.demo_zsports.adapter.ItemScheduleAdapter

@BindingAdapter("itemAthleteAdapter")
fun <T> setItemAthleteAdapter(recyclerView: RecyclerView, masterAdapter: ItemAthleteAdapter) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = masterAdapter
}

@BindingAdapter("itemScheduleAdapter")
fun <T> setItemAthleteAdapter(recyclerView: RecyclerView, masterAdapter: ItemScheduleAdapter) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = masterAdapter
}
