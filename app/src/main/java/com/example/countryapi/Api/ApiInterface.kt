package com.example.countryapi.Api

import com.example.countryapi.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/all")
    fun getData() : Call<List<CountryModel>>
}