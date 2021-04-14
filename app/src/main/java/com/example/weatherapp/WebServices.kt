package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("weather")
    fun getWeather(@Query("q") q:String , @Query("appid") apikey:String):Call<Response>

}