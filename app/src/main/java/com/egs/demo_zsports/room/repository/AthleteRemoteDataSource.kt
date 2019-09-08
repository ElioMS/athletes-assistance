package com.egs.demo_zsports.room.repository

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.egs.demo_zsports.model.Assistance
import com.egs.demo_zsports.model.Athlete
import com.google.gson.GsonBuilder
import org.json.JSONObject

class AthleteRemoteDataSource: AthletesRepository.Remote {
    override fun getSchedule(athleteId: Int, onScheduleReadyCallback: OnScheduleReadyCallback) {
        AndroidNetworking.get("http://192.168.1.9:8000/api/v1/athletes/$athleteId/schedule")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    val gson = GsonBuilder().create()
                    val list = gson.fromJson(response["data"].toString(), Array<Assistance>::class.java).toList()
                    onScheduleReadyCallback.onDataReady(ArrayList(list))
                }

                override fun onError(error: ANError) {
//                    Log.e("ddd", error.errorBody.toString())
                    Log.e("ddd", error.message)
                }
            })
    }

    override fun getAthletes(coachId: Int, onAthletesReadyCallback: OnAthletesReadyCallback) {
        AndroidNetworking.get("http://192.168.1.9:8000/api/v1/coach/1/athletes")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    val gson = GsonBuilder().create()
                    val list = gson.fromJson(response["data"].toString(), Array<Athlete>::class.java).toList()
                    onAthletesReadyCallback.onDataReady(ArrayList(list))
                }

                override fun onError(error: ANError) {
//                    Log.e("ddd", error.errorBody.toString())
                    Log.e("ddd", error.message)
                }
            })
    }

}

interface OnAthletesReadyCallback {
    fun onDataReady(data: ArrayList<Athlete>)
}

interface OnScheduleReadyCallback {
    fun onDataReady(data: ArrayList<Assistance>)
}