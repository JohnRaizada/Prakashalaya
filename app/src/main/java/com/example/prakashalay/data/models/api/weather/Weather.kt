package com.example.prakashalay.data.models.api.weather

data class Weather(
    val address: String = "", // 23.3506,85.3138
    val days: List<Day> = listOf(),
    val latitude: Double = 0.0, // 23.3506
    val longitude: Double = 0.0, // 85.3138
    val queryCost: Int = 0, // 1
    val resolvedAddress: String = "", // 23.3506,85.3138
    val stations: Stations = Stations(),
    val timezone: String = "", // Asia/Kolkata
    val tzoffset: Double = 0.0 // 5.5
)