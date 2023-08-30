package com.example.familyproject.model.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val lunarBaseUrl = ""

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(lunarBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}