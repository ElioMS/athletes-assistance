package com.egs.demo_zsports.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel

abstract class BaseViewModel <T> : ViewModel() {

    private var navigator: T? = null



    fun getNavigator() : T {
        return navigator!!
    }

    fun setNavigator(navigator: T) {
        this.navigator = navigator
    }

    fun logE(message: String?){
        Log.e(this.javaClass.simpleName, message?:"null")
    }

}