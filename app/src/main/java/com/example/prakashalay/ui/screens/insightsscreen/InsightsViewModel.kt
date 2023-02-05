package com.example.prakashalay.ui.screens.insightsscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.prakashalay.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class InsightsViewModel :ViewModel(){
    val nomenclature = "InsightsViewModel"
    private val _uiState = MutableStateFlow(InsightsUiState())
    val uiState: StateFlow<InsightsUiState> = _uiState.asStateFlow()
    fun updateUiState(){
        updateProgressBarValue()
        updateChargingStatus()
        updateChargingTimeLeft()
        Log.d(nomenclature, "Successfully updated Ui State")
    }
    private fun updateProgressBarValue(
    ) {
        _uiState.update {
            it.copy(
                progressBarValue = .37f
            )
        }
        Log.d(nomenclature, "Successfully updated progress bar value")
        Log.i(nomenclature, "Progress Bar Value: ${uiState.value.progressBarValue}")
    }
    private fun updateChargingStatus(
    ) {
        _uiState.update {
            it.copy(
                chargingStatus = R.string.notcharging
            )
        }
        Log.d(nomenclature, "Successfully updated charging status")
        Log.i(nomenclature, "Progress Bar Value: ${uiState.value.chargingTimeLeft}")
    }
    private fun updateChargingTimeLeft(

    ){
        _uiState.update{
            it.copy(
                chargingTimeLeft = "5h 13m"
            )
        }
        Log.d(nomenclature, "Successfully updated progress bar value")
        Log.i(nomenclature, "Progress Bar Value: ${uiState.value.progressBarValue}")
    }
    private fun updateTemperature(

    ) {
        _uiState.update {
        it.copy(
            temperature = "29°"
        )
    }
        Log.d(nomenclature, "Successfully updated temperature value")
        Log.i(nomenclature, "temperature Value: ${uiState.value.temperature}")
    }
    private fun updateWeatherStatus(

    ){
        _uiState.update{
            it.copy(
                weatherStatus = "Heavy Rain"
            )
        }
        Log.d(nomenclature, "Successfully updated weather status value")
        Log.i(nomenclature, "Weather Status: ${uiState.value.weatherStatus}")
    }
    private fun updateDayAndDate(

    ){
        _uiState.update{
            it.copy(
                dayAndDate = "Sat, 04 Feb"
            )
        }
        Log.d(nomenclature, "Successfully updated day and date value")
        Log.i(nomenclature, "Day and Date Value: ${uiState.value.dayAndDate}")
    }
}