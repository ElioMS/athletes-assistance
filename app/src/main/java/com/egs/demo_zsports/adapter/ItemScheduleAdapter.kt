package com.egs.demo_zsports.adapter

import com.egs.demo_zsports.databinding.RvItemScheduleBinding
import com.egs.demo_zsports.model.Assistance
import com.egs.demo_zsports.ui.holder.ItemScheduleViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ItemScheduleAdapter(var items: MutableList<Assistance>): RecyclerView.Adapter<ItemScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemScheduleViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemScheduleBinding.inflate(layoutInflater, parent, false)
        return ItemScheduleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemScheduleViewHolder, position: Int) {
        val model = items[position]
        holder.bind(model)
    }

    fun bindItems(data: MutableList<Assistance>) {
        this.items = data
        this.notifyDataSetChanged()
    }

}