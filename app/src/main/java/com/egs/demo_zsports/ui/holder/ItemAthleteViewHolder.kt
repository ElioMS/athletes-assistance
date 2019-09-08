package com.egs.demo_zsports.ui.holder

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.egs.demo_zsports.R
import com.egs.demo_zsports.databinding.RvItemAthletesBinding
import com.egs.demo_zsports.model.Athlete

class ItemAthleteViewHolder(private var binding: RvItemAthletesBinding): RecyclerView.ViewHolder(binding.root) {

    var container: ConstraintLayout = itemView.findViewById(R.id.rv_athlete_container)

    fun bind(data: Athlete) {
        binding.item = data
        binding.executePendingBindings()
    }

}