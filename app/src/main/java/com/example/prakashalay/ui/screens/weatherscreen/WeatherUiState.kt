package com.example.prakashalay.ui.screens.weatherscreen

import java.util.*

data class WeatherUiState(
    val temperature: Int = 0,
    val time: TimeZone = TimeZone.getDefault(),
    val sunrise: TimeZone = TimeZone.getDefault(),
    val sunset: TimeZone = TimeZone.getDefault(),
    val clear: Boolean = false,
    val rainy: Boolean = false,
    val windy: Boolean = false,
    val airQuality: Int = 0
)
