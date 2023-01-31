package com.example.prakashalay.data.models.ui.drawers.sidenavigation

import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen

data class MenuBoxItem(
    val icon: Int = R.drawable.ic_launcher_background,
    @StringRes val text: Int = R.string.app_name,
    val navRoute: String = Screen.HomeScreen.route
)
