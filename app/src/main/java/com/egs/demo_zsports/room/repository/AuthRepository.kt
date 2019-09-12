package com.egs.demo_zsports.room.repository

import com.egs.demo_zsports.model.NewUser

interface AuthRepository {

    interface Remote {
        fun login()
        fun register(data: NewUser, onAuthReadyCallback: OnRegisterReadyCallback)
    }

}