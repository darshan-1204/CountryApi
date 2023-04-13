package com.example.countryapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.countryapi.R

class PhoneCodeAdapter(callingCodes: List<String?>?) : Adapter<PhoneCodeAdapter.PhoneCodeHolder>() {

    var call = callingCodes
    var plus = "+"
    class PhoneCodeHolder(itemView: View) : ViewHolder(itemView) {

        var phone = itemView.findViewById<TextView>(R.id.txtPhoneCode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneCodeHolder {
        return PhoneCodeHolder(LayoutInflater.from(parent.context).inflate(R.layout.phone_code_item,parent,false))
    }

    override fun getItemCount(): Int {
        return call?.size!!
    }

    override fun onBindViewHolder(holder: PhoneCodeHolder, position: Int) {
        holder.phone.setText(plus+call?.get(position))
    }
}