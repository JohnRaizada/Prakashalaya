package com.example.prakashalay.data.models.api.weather

data class Hour(
    val cloudcover: Double = 0.0, // 0.0
    val conditions: String = "", // Clear
    val datetime: String = "", // 00:00:00
    val datetimeEpoch: Int = 0, // 1674153000
    val dew: Double = 0.0, // 11.0
    val feelslike: Double = 0.0, // 13.0
    val humidity: Double = 0.0, // 87.65
    val icon: String = "", // clear-night
    val precip: Double = 0.0, // 0.0
    val precipprob: Double = 0.0, // 0.0
    val preciptype: Any? = null, // null
    val pressure: Double = 0.0, // 1019.0
    val severerisk: Double = 0.0, // 10.0
    val snow: Double = 0.0, // 0.0
    val snowdepth: Double = 0.0, // 0.0
    val solarenergy: Double? = null, // 0.2
    val solarradiation: Double = 0.0, // 0.0
    val source: String = "", // obs
    val stations: List<String>? = null,
    val temp: Double = 0.0, // 13.0
    val uvindex: Double = 0.0, // 0.0
    val visibility: Double = 0.0, // 1.0
    val winddir: Double = 0.0, // 0.0
    val windgust: Double = 0.0, // 5.8
    val windspeed: Double = 0.0 // 0.0
)