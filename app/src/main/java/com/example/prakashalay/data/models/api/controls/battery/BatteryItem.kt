package com.example.prakashalay.data.models.api.controls.battery

data class BatteryItem(
    val battery_health: String = "", // Excellent
    val battery_level: Double = 0.0, // 40.0
    val battery_saver: Boolean = false, // false
    val battery_voltage: Double = 0.0, // 3.6
    val charging_speed: Double = 0.0, // 40.0
    val charging_status: Boolean = false, // false
    val id: Int = 0, // 1
    val smart_charging: Boolean = false, // false
    val time: String = "", // 2023-01-19T12:23:41.112602+05:30
    val time_left: String = "" // 06:53:37.246558
)