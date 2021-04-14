package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("weather")
    fun getWeather( @Query("appid") apikey:String,@Query("id") id:String):Call<Response>
    @GET("weather")
    fun getcity( @Query("appid") apikey:String , @Query("id") id:String):Call<Response>

}