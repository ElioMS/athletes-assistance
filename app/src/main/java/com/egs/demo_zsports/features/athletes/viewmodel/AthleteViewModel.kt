package com.egs.demo_zsports.features.athletes.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egs.demo_zsports.adapter.ItemAthleteAdapter
import com.egs.demo_zsports.adapter.ItemScheduleAdapter
import com.egs.demo_zsports.features.athletes.views.AthleteNavigator
import com.egs.demo_zsports.model.Assistance
import com.egs.demo_zsports.model.Athlete
import com.egs.demo_zsports.room.repository.*
import com.egs.demo_zsports.ui.base.BaseViewModel
import java.util.logging.Handler

class AthleteViewModel: BaseViewModel<AthleteNavigator>() {

    val adapter = ItemAthleteAdapter(arrayListOf()) {
        model, position -> showProfile(model, position)
    }

    val scheduleAdapter = ItemScheduleAdapter(arrayListOf())

    var repository: AssistanceRemoteDataSource = AssistanceRemoteDataSource()

    var athletesRepository: AthleteRemoteDataSource = AthleteRemoteDataSource()

    var athletes = MutableLiveData<ArrayList<Athlete>>()

    var currentAthlete = ObservableField<Athlete>()

    var isLoading = ObservableField<Boolean>()
    var showScheduleDialog = ObservableField<Boolean>()

    init {
        loadAthletes()
        isLoading.set(false)
        showScheduleDialog.set(false)
    }

    private fun loadAthletes() {
        athletesRepository.getAthletes(1, object: OnAthletesReadyCallback {
            override fun onDataReady(data: ArrayList<Athlete>) {
                athletes.value = data
                adapter.bindItems(data)
            }
        })
    }

    private fun showProfile(model: Athlete, position: Int) {
        currentAthlete.set(model)
        getNavigator().showAthleteProfile()
    }

    fun registerAssistance() {
        isLoading.set(true)
        Log.d("onlyid", currentAthlete.get()!!.id.toString())
        repository.updateAssistance(currentAthlete.get()!!.id, object: OnReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
            }
        })
    }

    fun getAthleteSchedule() {
        isLoading.set(true)

        athletesRepository.getSchedule(currentAthlete.get()!!.id, object: OnScheduleReadyCallback {
            override fun onDataReady(data: ArrayList<Assistance>) {
                scheduleAdapter.bindItems(data)
                isLoading.set(false)
                showScheduleDialog.set(true)
            }
        })
    }

    fun closeScheduleDialog() {
        showScheduleDialog.set(false)
    }

}