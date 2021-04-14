package com.example.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apimanager {
companion object{
    private var retrofit: Retrofit? = null
    @Synchronized
   private fun  getinstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https:\\api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit!!
        }
        return retrofit!!
    }

    fun getwebbservices():WebServices{
        return getinstance().create(WebServices::class.java)

    }
}
}
