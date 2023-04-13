package com.example.countryapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.countryapi.CurrenciesItem
import com.example.countryapi.R

class CurrencyAdapter(currencies: List<CurrenciesItem?>?) : Adapter<CurrencyAdapter.CurrencyHolder>() {

    var currencies = currencies
    class CurrencyHolder(itemView: View) : ViewHolder(itemView){

        var tvCurrency = itemView.findViewById<TextView>(R.id.txtCurrency)
        var tvCurrencySymbol = itemView.findViewById<TextView>(R.id.txtCurrencySymbol)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        return CurrencyHolder(LayoutInflater.from(parent.context).inflate(R.layout.currency_item,parent,false))
    }

    override fun getItemCount(): Int {
        return currencies?.size!!
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        holder.tvCurrency.setText(currencies?.get(position)?.name.toString())
        holder.tvCurrencySymbol.setText(currencies?.get(position)?.symbol.toString())
    }
}