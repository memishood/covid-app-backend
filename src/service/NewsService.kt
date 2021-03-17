package com.covidapp.service

import com.covidapp.api.NewsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private const val BASE_URL = "https://api.collectapi.com/"
    val api: NewsAPI
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
}