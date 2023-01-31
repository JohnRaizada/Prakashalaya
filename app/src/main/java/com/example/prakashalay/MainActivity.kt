package com.example.prakashalay

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.prakashalay.navigation.Navigation
import com.example.prakashalay.notification.PrakashalayNotificationService
import com.example.prakashalay.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private lateinit var dataStore: DataStore<Preferences>
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        createNotificationChannel()
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            AppTheme {
                Navigation()
            }
        }
    }
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            PrakashalayNotificationService.PRAKASHALAY_CHANNEL_ID,
            "Counter",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Used for the increment counter notifications"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}