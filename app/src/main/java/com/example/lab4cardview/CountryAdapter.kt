package com.example.lab4cardview

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    val dataset: List<Country>,
    private val onItemClick:(Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val image: ImageView = view.findViewById(R.id.cardImage)
            val countryName: TextView = view.findViewById(R.id.countryName)
            val population: TextView = view.findViewById(R.id.population)

            init {
                itemView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        onItemClick(dataset[position])
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.countryName.text = item.countryName
        holder.population.text = item.population.toString()
        holder.image.setImageResource(item.flagId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}