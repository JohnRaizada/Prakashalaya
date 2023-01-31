package com.example.prakashalay.data.models.api.weather

data class Day(
    val cloudcover: Double = 0.0, // 10.2
    val conditions: String = "", // Clear
    val datetime: String = "", // 2023-01-20
    val datetimeEpoch: Int = 0, // 1674153000
    val description: String = "", // Clear conditions throughout the day.
    val dew: Double = 0.0, // 7.8
    val feelslike: Double = 0.0, // 17.5
    val feelslikemax: Double = 0.0, // 25.3
    val feelslikemin: Double = 0.0, // 11.0
    val hours: List<Hour> = listOf(),
    val humidity: Double = 0.0, // 58.2
    val icon: String = "", // clear-day
    val moonphase: Double = 0.0, // 0.99
    val precip: Double = 0.0, // 0.0
    val precipcover: Double = 0.0, // 0.0
    val precipprob: Double = 0.0, // 0.0
    val preciptype: Any? = null, // null
    val pressure: Double = 0.0, // 1017.3
    val severerisk: Double = 0.0, // 10.0
    val snow: Double = 0.0, // 0.0
    val snowdepth: Double = 0.0, // 0.0
    val solarenergy: Double = 0.0, // 18.6
    val solarradiation: Double = 0.0, // 217.0
    val source: String = "", // comb
    val stations: List<String>? = null,
    val sunrise: String = "", // 06:32:20
    val sunriseEpoch: Int = 0, // 1674176540
    val sunset: String = "", // 17:27:10
    val sunsetEpoch: Int = 0, // 1674215830
    val temp: Double = 0.0, // 17.5
    val tempmax: Double = 0.0, // 25.3
    val tempmin: Double = 0.0, // 11.0
    val uvindex: Double = 0.0, // 8.0
    val visibility: Double = 0.0, // 13.6
    val winddir: Double = 0.0, // 174.5
    val windgust: Double = 0.0, // 11.9
    val windspeed: Double = 0.0 // 10.8
)