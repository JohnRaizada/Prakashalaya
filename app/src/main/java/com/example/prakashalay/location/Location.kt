package com.example.prakashalay.location

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.prakashalay.data.storage.Storage.save
import com.example.prakashalay.network.RequestHeaders
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

object Location {
    private const val nomenclature = "Location"
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var coordinates: android.location.Location? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun getLocation(
    context: Context
    ) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        if (
            (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
                    ) && (
                    ActivityCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                    )
        ) {
            Log.d(nomenclature, "Location permission not granted, requesting user for permissions")
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
            if (ActivityCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED) {
                Toast
                    .makeText(
                        context,
                        "Location permission not granted",
                        Toast.LENGTH_SHORT
                    ).show()
                Log.d(nomenclature,"Location permissions not granted")
            }
        }
        val location = fusedLocationProviderClient.lastLocation
        location.addOnCompleteListener {
            coordinates = it.result
            RequestHeaders.coordinates = coordinates
            Log.d(nomenclature,"Device successfully located")
            Log.i(nomenclature,"Latitude:\n${RequestHeaders.coordinates?.latitude}\nLongitude:${RequestHeaders.coordinates?.longitude}\nAltitude:${RequestHeaders.coordinates?.altitude}\nAccuracy:${RequestHeaders.coordinates?.accuracy}")
        }
    }
    suspend fun syncData(
        context: Context
    ){
        syncLatitude(context)
        syncLongitude(context)
        Log.d(nomenclature,"Successfully synced location data with storage")
    }
    private suspend fun syncLongitude(
        context: Context
    ) {
        if (coordinates?.longitude == null) {
            Log.i(nomenclature, "Improper longitude data supplied")
            return
        }
        save(
            key = "longitude",
            context =context,
            value = coordinates?.longitude.toString()
        )
        Log.i(nomenclature, "Successfully synced longitude data")
    }
    private suspend fun syncLatitude(
        context: Context
    ){
        if (coordinates?.latitude == null) {
            Log.i(nomenclature, "Improper latitude data supplied")
            return
        }
        save(
            key = "latitude",
            context =context,
            value = coordinates?.latitude.toString()
        )
        Log.i(nomenclature, "Successfully synced latitude data")
    }
}
