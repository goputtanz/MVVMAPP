package com.example.machinetestnewage.presentation.planetary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.ItemPlanetaryBinding
import com.example.machinetestnewage.domain.model.PlanetaryData

class PlanetaryAdapter(val listener: PlanetaryItemClick) :
    ListAdapter<PlanetaryData, RecyclerView.ViewHolder>(diffUtil) {


    private object diffUtil : DiffUtil.ItemCallback<PlanetaryData>() {
        override fun areItemsTheSame(oldItem: PlanetaryData, newItem: PlanetaryData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PlanetaryData, newItem: PlanetaryData): Boolean {
            return oldItem.title == newItem.title
        }

    }

    inner class MyViewHolder(val binding: ItemPlanetaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlanetaryData) {
            with(binding) {
                planetaryTitle.setText(item.title)
                planetaryDate.setText(item.date)
                planetsImage.load(item.url){
                    placeholder(R.drawable.image_placeholder)
                }
                root.setOnClickListener {
                    listener.onItemClick(item)
                }
            }
        }
    }

    interface PlanetaryItemClick {
        fun onItemClick(item: PlanetaryData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemPlanetaryBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).bind(getItem(position))
    }


}