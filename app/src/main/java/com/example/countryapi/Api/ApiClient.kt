package com.example.countryapi.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{
        lateinit var retrofit: Retrofit
        var BASE_URL = "https://restcountries.com/"
        fun getClient(): Retrofit {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}