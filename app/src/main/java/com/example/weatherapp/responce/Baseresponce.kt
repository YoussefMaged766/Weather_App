package com.example.weatherapp.responce

import com.google.gson.annotations.SerializedName

 open class baseresponce {
    data class Sys(

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("sunrise")
        val sunrise: Int? = null,

        @field:SerializedName("sunset")
        val sunset: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("type")
        val type: Int? = null
    )

    data class Clouds(

        @field:SerializedName("all")
        val all: Int? = null
    )

    data class WeatherItem(

        @field:SerializedName("icon")
        val icon: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("main")
        val main: String? = null,

        @field:SerializedName("id")
        val id: Int? = null
    )

    open class Coord(

        @field:SerializedName("lon")
        val lon: Double? = null,

        @field:SerializedName("lat")
        val lat: Double? = null
    )

    data class Wind(

        @field:SerializedName("deg")
        val deg: Int? = null,

        @field:SerializedName("speed")
        val speed: Double? = null
    )

    data class Main(

        @field:SerializedName("temp")
        val temp: Double? = null,

        @field:SerializedName("temp_min")
        val tempMin: Double? = null,

        @field:SerializedName("humidity")
        val humidity: Int? = null,

        @field:SerializedName("pressure")
        val pressure: Int? = null,

        @field:SerializedName("feels_like")
        val feelsLike: Double? = null,

        @field:SerializedName("temp_max")
        val tempMax: Double? = null
    )
}