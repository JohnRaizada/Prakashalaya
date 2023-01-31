package com.example.prakashalay.ui.screens.registerscreen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prakashalay.data.models.api.account.register.RecieveRegister
import com.example.prakashalay.data.models.api.account.register.SendRegister
import com.example.prakashalay.location.Location
import com.example.prakashalay.network.ControllerService
import com.example.prakashalay.network.ServiceBuilder
import com.example.prakashalay.network.RequestHeaders
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class RegisterViewModel: ViewModel() {
    val nomenclature = "RegisterViewModel"
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()
    fun sendRegistrationData(
        context: Context,
        sendRegister: SendRegister
    ) {
        RequestHeaders.parameter = "registration"
        viewModelScope.launch {
            Location.syncData(context = context)
            makeRegistrationRequest(
                context=context,
                sendRegister=sendRegister
            )
        }
    }
    private fun makeRegistrationRequest(
        context: Context,
        sendRegister: SendRegister
    ){
        val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
        val requestCall = controllerService.postRegistrationData(sendRegister)
        requestCall.enqueue(object :
        retrofit2.Callback<RecieveRegister>{
            override fun onResponse(
                call: Call<RecieveRegister>,
                response: Response<RecieveRegister>
            ) {
                if (response.isSuccessful) {
                    Log.d(nomenclature,"Successfully made registration request")
                    Log.i(nomenclature, "Data:\nHeader:${response.headers()}\nBody:${response.body()}")
                    if (response.body()?.message == "Username already exists") {
                        Toast
                            .makeText(
                                context,
                                "Username already taken",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                        Log.d(nomenclature,"Username already exists")
                    }
                    RequestHeaders.userId = response.body()?.userId.toString()
                    Log.d(nomenclature,"Successfully set userId to ${RequestHeaders.userId}")
                    return
                }
                Toast
                    .makeText(
                        context,
                        "Registration was unsuccessful",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }

            override fun onFailure(call: Call<RecieveRegister>, t: Throwable) {
                Log.d(nomenclature,"There was an error while trying to make registration request")
                Log.i(nomenclature,"Error:\n$t")
                Toast
                    .makeText(
                        context,
                        "Unable to make contact server",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        })
    }
}