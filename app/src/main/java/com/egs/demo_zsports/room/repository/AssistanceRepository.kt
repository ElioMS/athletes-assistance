package com.egs.demo_zsports.room.repository

interface AssistanceRepository {

    interface Remote {
        fun updateAssistance(athleteId: Int, onReadyCallback: OnReadyCallback)
    }

}