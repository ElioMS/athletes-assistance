package com.egs.demo_zsports.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egs.demo_zsports.databinding.RvItemAthletesBinding
import com.egs.demo_zsports.model.Athlete
import com.egs.demo_zsports.ui.holder.ItemAthleteViewHolder

class ItemAthleteAdapter(var items: MutableList<Athlete>,
                         var listener: (Athlete, Int) -> Unit): RecyclerView.Adapter<ItemAthleteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAthleteViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemAthletesBinding.inflate(layoutInflater, parent, false)
        return ItemAthleteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemAthleteViewHolder, position: Int) {
        val model = items[position]
        holder.bind(model)
        holder.container.setOnClickListener { listener.invoke(model, position) }
    }

    fun bindItems(data: MutableList<Athlete>) {
        this.items = data
        this.notifyDataSetChanged()
    }

}