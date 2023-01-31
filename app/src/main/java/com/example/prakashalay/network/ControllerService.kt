package com.example.prakashalay.network

import com.example.prakashalay.data.models.api.account.accountmanagement.RecieveProfile
import com.example.prakashalay.data.models.api.account.login.RecieveLogin
import com.example.prakashalay.data.models.api.account.login.SendLogin
import com.example.prakashalay.data.models.api.account.register.RecieveRegister
import com.example.prakashalay.data.models.api.account.register.SendRegister
import com.example.prakashalay.data.models.api.weather.Weather
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ControllerService {
    @GET("weather/")
    fun getWeather(): Call<Weather>
    @POST("account/register/")
    fun postRegistrationData(@Body sendRegister: SendRegister): Call<RecieveRegister>
    @GET("account/accountmanagement/")
    fun getProfile(): Call<RecieveProfile>
    @POST("account/login/")
    fun postLoginData(@Body sendLogin: SendLogin): Call<RecieveLogin>
}