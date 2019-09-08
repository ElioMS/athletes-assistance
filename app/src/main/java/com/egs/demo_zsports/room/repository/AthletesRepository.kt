package com.egs.demo_zsports.room.repository

import com.egs.demo_zsports.model.Athlete

interface AthletesRepository {

    interface Remote {
        fun getAthletes(coachId: Int, onAthletesReadyCallback: OnAthletesReadyCallback)

        fun getSchedule(athleteId: Int, onScheduleReadyCallback: OnScheduleReadyCallback)
    }

}