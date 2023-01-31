package com.example.prakashalay.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.prakashalay.MainActivity
import com.example.prakashalay.R

class PrakashalayNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotifications(
        //Get dynamic variable
    ) {
        val activityIntent = Intent(context,MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context,PrakashalayNotificationReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, PRAKASHALAY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Prakashalay Notification")
            .setContentText("This is Prakashalay official")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Click Here",
                incrementIntent
            )
            .build()
        notificationManager.notify(1,notification)
    }
    companion object{
        const val PRAKASHALAY_CHANNEL_ID = "prakashalay_channel"
    }
}