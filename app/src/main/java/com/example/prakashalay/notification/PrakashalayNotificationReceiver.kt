package com.example.prakashalay.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PrakashalayNotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let { PrakashalayNotificationService(it) }?.showNotifications(
            //Do some action
        )
    }
}