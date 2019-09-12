package com.egs.demo_zsports.features.register.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import com.egs.demo_zsports.features.register.views.RegisterNavigator
import com.egs.demo_zsports.model.NewUser
import com.egs.demo_zsports.room.repository.AuthRemoteDataSource
import com.egs.demo_zsports.room.repository.OnRegisterReadyCallback
import com.egs.demo_zsports.ui.base.BaseViewModel

class RegisterViewModel: BaseViewModel<RegisterNavigator>() {

    private var repository: AuthRemoteDataSource = AuthRemoteDataSource()

    val isLoading = ObservableField<Boolean>(false)

    val name = ObservableField<String>("")
    val email = ObservableField<String>("")
    val password = ObservableField<String>("")

    fun sendData() {

        isLoading.set(true)

        val data = NewUser(name.get()!!, email.get()!!, password.get()!!)
        Log.d("register", data.toString())

        getNavigator().showSuccessDialog()

//        repository.register(data, object: OnRegisterReadyCallback {
//            override fun onRegisterSuccess(response: String) {
//                isLoading.set(false)
//            }
//
//            override fun onRegisterFailed(response: String) {
//                isLoading.set(false)
//            }
//        })
    }

}