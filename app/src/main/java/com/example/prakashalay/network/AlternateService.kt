package com.example.prakashalay.network

import com.example.prakashalay.data.models.api.weather.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface AlternateService {
    @GET
        fun getWeather(@Url anotherUrl: String): Call<Weather>
}