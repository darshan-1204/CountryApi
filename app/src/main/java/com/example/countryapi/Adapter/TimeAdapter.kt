package com.example.countryapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.countryapi.R

class TimeAdapter(timezones: List<String?>?) : Adapter<TimeAdapter.TimeHolder>() {

    var time = timezones
    class TimeHolder(itemView: View) : ViewHolder(itemView){

        var tvTime = itemView.findViewById<TextView>(R.id.txtTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeHolder {
        return TimeHolder(LayoutInflater.from(parent.context).inflate(R.layout.time_item,parent,false))
    }

    override fun getItemCount(): Int {
        return time?.size!!
    }

    override fun onBindViewHolder(holder: TimeHolder, position: Int) {
        holder.tvTime.setText(time?.get(position))
    }
}