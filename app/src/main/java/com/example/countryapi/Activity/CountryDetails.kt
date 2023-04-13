package com.example.countryapi.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.countryapi.Adapter.CurrencyAdapter
import com.example.countryapi.Adapter.LanguageAdapter
import com.example.countryapi.Adapter.PhoneCodeAdapter
import com.example.countryapi.Adapter.TimeAdapter
import com.example.countryapi.databinding.ActivityCountryDetailsBinding

class CountryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos = intent.getIntExtra("pos", 0)

        var data = MainActivity.data

        if (pos != null) {
            binding.countryName.setText(data.get(pos).name)
            Glide.with(this).load(data.get(pos).flags?.png).into(binding.countryFlag)
            Glide.with(this).load(data.get(pos).flags?.png).into(binding.bigFlag)
            binding.alpha3ode.setText(data.get(pos).alpha3Code)
            binding.capital.setText(data.get(pos).capital)
            binding.Capital.setText(data.get(pos).capital)
            binding.region.setText(data.get(pos).region)
            binding.area.setText(data.get(pos).area.toString())
            binding.population.setText(data.get(pos).population.toString())

            binding.rcvLanguage.layoutManager = GridLayoutManager(this, 3)
            binding.rcvLanguage.adapter = LanguageAdapter(data.get(pos).languages)


            binding.rcvCurrency.layoutManager = LinearLayoutManager(this)
            binding.rcvCurrency.adapter = CurrencyAdapter(data.get(pos).currencies)

            binding.rcvPhoneCode.layoutManager = LinearLayoutManager(this)
            binding.rcvPhoneCode.adapter = PhoneCodeAdapter(data.get(pos).callingCodes)

            binding.rcvTime.layoutManager = LinearLayoutManager(this)
            binding.rcvTime.adapter = TimeAdapter(data.get(pos).timezones)
        }

    }
}