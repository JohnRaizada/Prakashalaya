package com.example.prakashalay.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("homeScreen")
    object BatteryScreen : Screen("batteryScreen")
    object SplashScreen : Screen("splashScreen")
    object FlapScreen : Screen("flapScreen")
    object PanelScreen :  Screen("panelScreen")
    object WeatherScreen : Screen("weatherScreen")
    object FeedbackScreen : Screen("feedbackScreen")
    object HouseMapScreen : Screen("housemapScreen")
    object AboutScreen : Screen("aboutUsScreen")
    object SettingScreen : Screen("settingScreen")
    object ProfileScreen : Screen("profileScreen")
    object RoomScreen : Screen("roomScreen")
    object InsightsScreen : Screen("insightsScreen")
}
