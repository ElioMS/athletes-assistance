package com.egs.demo_zsports.room.repository

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.egs.demo_zsports.model.Assistance
import com.egs.demo_zsports.model.NewUser
import com.google.gson.GsonBuilder
import org.json.JSONObject

class AuthRemoteDataSource: AuthRepository.Remote {

    override fun login() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(data: NewUser, onAuthReadyCallback: OnRegisterReadyCallback) {
        AndroidNetworking.post("http://192.168.1.9:8000/api/v1/register")
            .addBodyParameter(data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    onAuthReadyCallback.onRegisterSuccess("success")
                }

                override fun onError(error: ANError) {
                    onAuthReadyCallback.onRegisterFailed("error")
                }
            })
    }
}

interface OnLoginReadyCallback {
    fun onLoginSuccess()
    fun onLoginFailed()
}

interface OnRegisterReadyCallback {
    fun onRegisterSuccess(response: String)
    fun onRegisterFailed(response: String)
}