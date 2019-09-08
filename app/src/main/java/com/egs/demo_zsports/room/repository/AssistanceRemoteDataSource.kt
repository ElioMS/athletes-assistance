package com.egs.demo_zsports.room.repository

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject

class AssistanceRemoteDataSource: AssistanceRepository.Remote {

    override fun updateAssistance(athleteId: Int, onReadyCallback: OnReadyCallback) {

        AndroidNetworking.post("http://192.168.1.9:8000/api/v1/assistance")
            .addBodyParameter("athlete_id", athleteId.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.d("ddd", "aaaa")
                    onReadyCallback.onDataReady("Ok")
                }

                override fun onError(error: ANError) {
//                    Log.e("ddd", error.errorBody.toString())
                    Log.e("ddd", error.message)
                }
            })
    }

}

interface OnReadyCallback {
    fun onDataReady(data: String)
}