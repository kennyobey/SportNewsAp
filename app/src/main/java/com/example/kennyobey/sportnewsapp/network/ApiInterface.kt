package com.example.kennyobey.sportnewsapp.network

import com.example.kennyobey.sportnewsapp.datamodel.NewsFetch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //specify the endpoint to get popular movies from
    @GET("popular")
    fun getNews(@Query("api_key") apiKey :String,
                @Query("country") country :String,
                @Query("sort") sortBy :String,
                @Query("category") category : String) : Call<NewsFetch>
}