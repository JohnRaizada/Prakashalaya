package com.example.prakashalay.ui.screens.loginscreen

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prakashalay.data.models.api.account.login.RecieveLogin
import com.example.prakashalay.data.models.api.account.login.SendLogin
import com.example.prakashalay.data.storage.Storage.read
import com.example.prakashalay.data.storage.Storage.save
import com.example.prakashalay.location.Location
import com.example.prakashalay.network.ControllerService
import com.example.prakashalay.network.RequestHeaders
import com.example.prakashalay.network.ServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class LoginViewModel: ViewModel() {
    val nomenclature = "LoginViewModel"
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun login(
        context: Context,
        sendLogin: SendLogin
    ) {
        RequestHeaders.parameter = "login"
        viewModelScope.launch {
            val username = read(
                key = "userid",
                context = context
            )
            Location.getLocation(context)
            if (!username.isNullOrBlank()){
                RequestHeaders.userId = username
                Toast
                    .makeText(
                        context,
                        "Already logged in",
                        Toast.LENGTH_SHORT
                    )
                    .show()
                return@launch
            }
            postLoginData(
                context=context,
                sendLogin = sendLogin
            )
            save(
                key = "userid",
                value = RequestHeaders.userId,
                context = context
            )
        }
    }
    private fun postLoginData(
        context: Context,
        sendLogin: SendLogin
    ) {
        val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
        val requestCall = controllerService.postLoginData(
            sendLogin = sendLogin
        )
        requestCall.enqueue(object :
        retrofit2.Callback<RecieveLogin>{
            override fun onResponse(call: Call<RecieveLogin>, response: Response<RecieveLogin>) {
                if (response.isSuccessful) {
                    Log.d(nomenclature,"Successfully logged in")
                    Log.i(nomenclature,"Data:\nHeader${response.headers()}\nBody:${response.body()}")
                    RequestHeaders.userId = response.body()?.userId.toString()
                    Toast
                        .makeText(
                            context,
                            "Login successful",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                    return
                }
                Log.w(nomenclature,"We encountered a problem while trying to communicate with service")
                Toast
                    .makeText(
                        context,
                        "Login failed",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
            override fun onFailure(call: Call<RecieveLogin>, t: Throwable) {
                Log.e(nomenclature,"It seems there was an error while communicating with service")
                Log.i(nomenclature,"Error:\n$t")
                Toast
                    .makeText(
                        context,
                        "Login unsuccessful",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }

        })
    }
}