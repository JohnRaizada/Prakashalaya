package com.example.prakashalay.data.models.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen

sealed class BottomNavigationDrawerItem(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    val navRoute: String
) {
    object Home: BottomNavigationDrawerItem(R.string.app_name, R.drawable.ic_launcher_background,Screen.HomeScreen.route)
    object L: BottomNavigationDrawerItem(R.string.app_name, R.drawable.ic_launcher_background,Screen.BatteryScreen.route)
    object A: BottomNavigationDrawerItem(R.string.app_name, R.drawable.ic_launcher_background,Screen.WeatherScreen.route)
    object AA: BottomNavigationDrawerItem(R.string.app_name, R.drawable.ic_launcher_background,Screen.FlapScreen.route)
    object P: BottomNavigationDrawerItem(R.string.app_name, R.drawable.ic_launcher_background,Screen.HomeScreen.route)

}