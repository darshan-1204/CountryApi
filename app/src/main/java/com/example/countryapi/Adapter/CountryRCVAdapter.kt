package com.example.countryapi.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.countryapi.Activity.CountryDetails
import com.example.countryapi.CountryModel
import com.example.countryapi.R

class CountryRCVAdapter(data: List<CountryModel>?) : Adapter<CountryRCVAdapter.CountryHolder>() {

    lateinit var context: Context
    var data = data

    class CountryHolder(itemView: View) : ViewHolder(itemView) {

        var img = itemView.findViewById<ImageView>(R.id.imgCountry)
        var txt = itemView.findViewById<TextView>(R.id.tvCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        context = parent.context
        return CountryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.txt.text = data?.get(position)?.name
        Glide.with(context).load(data?.get(position)?.flags?.png).into(holder.img)

        holder.itemView.setOnClickListener {

            var intent = Intent(context, CountryDetails::class.java)
            intent.putExtra("pos",position)
            context.startActivity(intent)

        }

    }

}