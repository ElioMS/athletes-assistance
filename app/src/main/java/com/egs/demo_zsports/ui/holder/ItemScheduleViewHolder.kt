package com.egs.demo_zsports.ui.holder

import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.egs.demo_zsports.R
import com.egs.demo_zsports.databinding.RvItemScheduleBinding
import com.egs.demo_zsports.model.Assistance

class ItemScheduleViewHolder(private var binding: RvItemScheduleBinding): RecyclerView.ViewHolder(binding.root) {

    var container: LinearLayout = itemView.findViewById(R.id.rv_schedule_container)

    fun bind(data: Assistance) {
        binding.assistance = data
        binding.executePendingBindings()
    }

}