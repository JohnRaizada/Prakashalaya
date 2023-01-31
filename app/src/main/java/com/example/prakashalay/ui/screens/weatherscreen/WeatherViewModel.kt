package com.example.prakashalay.ui.screens.weatherscreen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prakashalay.R
import com.example.prakashalay.data.models.api.weather.Weather
import com.example.prakashalay.network.AlternateService
import com.example.prakashalay.network.ControllerService
import com.example.prakashalay.network.RequestHeaders
import com.example.prakashalay.network.ServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class WeatherViewModel: ViewModel() {
    val nomenclature = "WeatherViewModel"
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
    private fun getPrimaryWeatherData(context: Context) {
        val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
        //Todo add api modification logic based on location
        val requestCall = controllerService.getWeather()
        requestCall.enqueue(object :
            retrofit2.Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.isSuccessful) {
                    Log.d(nomenclature, "Successfully received data from primary source")
                    Log.i(nomenclature, "Data:\nHeader:${response.headers()}\nBody:${response.body()}")
                    //Todo retrieve logic from response.body() and remember to return
                    return
                }
                getAlternateWeatherData(context)
            }
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.w(nomenclature,"Unable to getPrimaryWeatherData due to:\n$t")
                getAlternateWeatherData(context)
            }
        }
        )
    }
    private fun  getAlternateWeatherData(context: Context){
        val controllerService = ServiceBuilder.buildService(AlternateService::class.java)
        //Todo add api modification logic based on location
        val requestCall = controllerService.getWeather("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/23.3506%2C85.3138?unitGroup=metric&include=hours&key=8S267M7V3DZ4PAZPE9287MFYS&contentType=json")
        requestCall.enqueue(object :
            retrofit2.Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.isSuccessful) {
                    Log.d(nomenclature, "Successfully received data from primary source")
                    Log.i(nomenclature, "Data:\nHeader:${response.headers()}\nBody:${response.body()}")
                    //Todo retrieve logic from response.body()  and remember to return
                    return
                }
            }
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e(nomenclature, "Unable to get weather data from alternate source due to:\n$t")
                Toast
                    .makeText(
                        context,
                        "Unable to load details",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
            }
        )
    }
    fun fetchWeatherDetails(context: Context){
        RequestHeaders.parameter = "weather"
        viewModelScope.launch{
            getPrimaryWeatherData(context = context)
        }
    }
    fun imageResourceDecider(): Int {
        return R.drawable.ic_launcher_background
    }
}