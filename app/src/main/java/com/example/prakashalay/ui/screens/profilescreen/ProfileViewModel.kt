package com.example.prakashalay.ui.screens.profilescreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prakashalay.network.ControllerService
import com.example.prakashalay.network.RequestHeaders
import com.example.prakashalay.network.ServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {
    val nomenclature = "ProfileViewModel"
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
    fun getProfileData(
        context: Context
    ) {
        RequestHeaders.parameter = "accountmanagement"
        viewModelScope.launch {
            fetchProfileData(
                context = context
            )
        }
    }
    private fun fetchProfileData(
        context: Context
    ) {
        val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
        val requestCall = controllerService.getProfile()
    }
}