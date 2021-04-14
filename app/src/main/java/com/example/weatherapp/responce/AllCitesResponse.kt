package com.example.weatherapp

import com.example.weatherapp.responce.baseresponce
import com.google.gson.annotations.SerializedName

data class AllCitesResponse(

	@field:SerializedName("AllCitesResponse")
	val allCitesResponse: List<AllCitesResponseItem?>? = null
)

data class AllCitesResponseItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("coord")
	val coord: Coord? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: String? = null
): baseresponce()


