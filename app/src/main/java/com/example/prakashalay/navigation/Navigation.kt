package com.example.prakashalay.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import com.example.prakashalay.ui.layout.animations.Loading
import com.example.prakashalay.ui.screens.aboutscreen.AboutScreen
import com.example.prakashalay.ui.screens.batteryscreen.BatteryScreen
import com.example.prakashalay.ui.screens.feedbackscreen.FeedbackScreen
import com.example.prakashalay.ui.screens.flapscreen.FlapScreen
import com.example.prakashalay.ui.screens.homescreen.HomeScreen
import com.example.prakashalay.ui.screens.mapscreen.MapScreen
import com.example.prakashalay.ui.screens.panelscreen.PanelScreen
import com.example.prakashalay.ui.screens.profilescreen.ProfileScreen
import com.example.prakashalay.ui.screens.settingscreen.SettingScreen
import com.example.prakashalay.ui.screens.weatherscreen.WeatherScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val nomenclature = "Navigation"
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(
            route = Screen.BatteryScreen.route,
            enterTransition = {
                fadeIn()
            }
        ) {
            BatteryScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.SplashScreen.route) {
            Loading(navController)
        }
        composable(route = Screen.FlapScreen.route) {
            FlapScreen(navController)
        }
        composable(route = Screen.PanelScreen.route) {
            PanelScreen(navController)
        }
        composable(route = Screen.WeatherScreen.route) {
            WeatherScreen(navController)
        }
        composable(route=Screen.FeedbackScreen.route){
            FeedbackScreen(navController)
        }
        composable(route = Screen.HouseMapScreen.route){
            MapScreen(navController = navController)
        }
        composable(route=Screen.AboutScreen.route){
            AboutScreen(navController = navController)
        }
        composable(route=Screen.SettingScreen.route){
            SettingScreen(navController = navController)
        }
        composable(route=Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
    Log.i(nomenclature, "Successfully created $nomenclature rules.")
    }
}

