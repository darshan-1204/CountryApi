package com.example.countryapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.countryapi.LanguagesItem
import com.example.countryapi.R

class LanguageAdapter(languages: List<LanguagesItem?>?) : Adapter<LanguageAdapter.LanguageHolder>() {

    var languages = languages
    class LanguageHolder(itemView: View) : ViewHolder(itemView){
        var tvLanguage = itemView.findViewById<TextView>(R.id.txtLanguage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        return LanguageHolder(LayoutInflater.from(parent.context).inflate(R.layout.language_item,parent,false))
    }

    override fun getItemCount(): Int {
        return languages?.size!!
    }

    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.tvLanguage.setText(languages?.get(position)?.name.toString())
    }
}