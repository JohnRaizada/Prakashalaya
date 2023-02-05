package com.example.prakashalay.data.models.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen

sealed class BottomNavigationDrawerItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: BottomNavigationDrawerItem(R.string.home, R.drawable.home,Screen.HomeScreen.route)
    object Room: BottomNavigationDrawerItem(R.string.room, R.drawable.rooms,Screen.RoomScreen.route)
    object Insights: BottomNavigationDrawerItem(R.string.insights, R.drawable.insights,Screen.InsightsScreen.route)
}