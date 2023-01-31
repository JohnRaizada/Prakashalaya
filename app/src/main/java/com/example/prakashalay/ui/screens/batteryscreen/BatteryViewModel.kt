package com.example.prakashalay.ui.screens.batteryscreen
//
//import android.content.Context
//import android.util.Log
//import android.widget.Toast
import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.prakashalay.data.models.network.Battery
//import com.example.prakashalay.network.ControllerService
//import com.example.prakashalay.network.ServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import retrofit2.Call
//import retrofit2.Response
//
class BatteryViewModel: ViewModel() {
    val nomenclature = "BatteryViewModel"
    private val _uiState = MutableStateFlow(BatteryUiState())
    val uiState: StateFlow<BatteryUiState> = _uiState.asStateFlow()
//    private fun getBatteryLevel(context: Context) {
//        val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
//        val requestCall = controllerService.getBatteryLevel()
//        requestCall.enqueue(object :
//            retrofit2.Callback<Battery>{
//            override fun onFailure(call: Call<Battery>, t: Throwable) {
//                Toast
//                    .makeText(context, "Failed to retrieve details $t",
//                        Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun onResponse(call: Call<Battery>, response: Response<Battery>) {
//                if (response.isSuccessful){
//                    val batteryLevel = response.body()
//                    Log.d(nomenclature, "Successfully got response $batteryLevel")
//                } else {
//                    Toast
//                        .makeText(context, "Failed to retrieve details", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//        }
//        )
//        val newBattery = Battery()
//        newBattery.level = "50"
//        val requestCall1 = controllerService.addBatteryLevel(newBattery)
//        requestCall1.enqueue(object :
//            retrofit2.Callback<Battery>{
//            override fun onFailure(call: Call<Battery>, t: Throwable) {
//                Toast
//                    .makeText(context, "Failed to retrieve details $t",
//                        Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun onResponse(call: Call<Battery>, response: Response<Battery>) {
//                if (response.isSuccessful){
//                    val batteryLevel = response.body()
//                    Log.d(nomenclature, "Successfully Added")
//                } else {
//                    Toast
//                        .makeText(context, "Failed to retrieve details", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//        }
//        )
//    }
//    fun fetchBatteryLevel(context: Context){
//        viewModelScope.launch{
//            getBatteryLevel(context = context)
//        }
//    }
}