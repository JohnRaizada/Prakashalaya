package com.example.prakashalay.ui.screens.insightsscreen

import com.example.prakashalay.R

data class InsightsUiState(
    val progressBarValue: Float = .37f,
    val chargingStatus: Int = R.string.charging,
    val chargingTimeLeft: String = "5h 13m",
    val temperature: String = "29°",
    val weatherStatus: String = "Heavy Rain",
    val dayAndDate: String = "Sat, 04 Feb"
)
