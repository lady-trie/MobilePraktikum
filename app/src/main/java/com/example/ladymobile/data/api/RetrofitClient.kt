package com.example.ladymobile.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val CAT_FACT_BASE_URL = "https://catfact.ninja/"
    private const val PICSUM_BASE_URL = "https://picsum.photos/"

    val catFactApiService: CatFactApiService by lazy {
        Retrofit.Builder()
            .baseUrl(CAT_FACT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatFactApiService::class.java)
    }

    val picsumApiService: PicsumApiService by lazy {
        Retrofit.Builder()
            .baseUrl(PICSUM_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicsumApiService::class.java)
    }
}
