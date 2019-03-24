package com.example.kennyobey.sportnewsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        //base url is the base url of our api url that doesn't change
        private const val baseUrl = "https://newsapi.org/v2/sources/"          //https://api.themoviedb.org/3/movie/"
        fun getRetrofit (): Retrofit {
            //initialize retrofit with the base url and gson converters
            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

