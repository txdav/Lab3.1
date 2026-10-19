package com.example.lab31

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.widget.ImageView

class NationalParksRecyclerViewAdapter(private val parks: List<NationalPark>) :
    RecyclerView.Adapter<NationalParksRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parkImage: ImageView =
            itemView.findViewById(R.id.park_image)
        val parkName: TextView = view.findViewById(R.id.park_name)
        val parkLocation: TextView = view.findViewById(R.id.park_location)
        val parkDescription: TextView = view.findViewById(R.id.park_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_national_park, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val park = parks[position]

        holder.parkName.text = park.name
        holder.parkLocation.text = park.location
        holder.parkDescription.text = park.description

        Glide.with(holder.itemView)
            .load(park.imageUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_report_image)
            .into(holder.parkImage)
    }

    override fun getItemCount(): Int = parks.size
}
