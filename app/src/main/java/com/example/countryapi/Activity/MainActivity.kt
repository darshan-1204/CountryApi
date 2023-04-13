package com.example.countryapi.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapi.Adapter.CountryRCVAdapter
import com.example.countryapi.Api.ApiClient
import com.example.countryapi.Api.ApiInterface
import com.example.countryapi.CountryModel
import com.example.countryapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding : ActivityMainBinding
    companion object{
        var data  = ArrayList<CountryModel>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        apiInterface.getData().enqueue(object : Callback<List<CountryModel>>{
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                data = response.body() as ArrayList<CountryModel>

                binding.rcvCountry.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rcvCountry.adapter = CountryRCVAdapter(data)
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                Log.e(TAG, "onFailure: Something Went Wrong" + t.message)
            }

        })
    }

}