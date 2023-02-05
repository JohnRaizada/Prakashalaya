package com.example.prakashalay.data.repository

import com.example.prakashalay.R
import com.example.prakashalay.data.models.ui.BottomNavigationDrawerItem
import com.example.prakashalay.data.models.ui.drawers.sidenavigation.MenuBoxItem
import com.example.prakashalay.data.models.ui.HomeScreenRecommendedBox
import com.example.prakashalay.data.models.ui.HomeScreenSnapshotBox
import com.example.prakashalay.data.models.ui.drawers.sidenavigation.BottomBoxItem
import com.example.prakashalay.navigation.Screen

object DataRepository {
    val navigationDrawerItems = listOf(
        BottomNavigationDrawerItem.Insights,
        BottomNavigationDrawerItem.Home,
        BottomNavigationDrawerItem.Room
    )
    val sideNavigationDrawerMenuItems = listOf(
        MenuBoxItem(
            text = R.string.Feedback,
            navRoute = Screen.FeedbackScreen.route
        ),
        MenuBoxItem(
            text = R.string.HouseMap,
            navRoute = Screen.HouseMapScreen.route
        ),
        MenuBoxItem(
            text = R.string.Aboutus,
            navRoute = Screen.AboutScreen.route
        ),
        MenuBoxItem(
            text = R.string.Setting,
            navRoute = Screen.SettingScreen.route
        )
    )
    val sideNavigationDrawerBottomItems = listOf(
        BottomBoxItem(
            link = R.string.InstagramLink
        ),
        BottomBoxItem(
            link = R.string.YoutubeLink
        ),
        BottomBoxItem(
            link = R.string.WhatsappLink
        ),
        BottomBoxItem(
            link = R.string.FacebookLink
        ),
        BottomBoxItem(
            link = R.string.TwitterLink
        ),
    )
    val weatherScreenBackgroundImages = listOf(
        R.drawable.ic_launcher_background
    )
    val homeScreenSnapshotBoxes = listOf(
        HomeScreenSnapshotBox(),
        HomeScreenSnapshotBox(),
        HomeScreenSnapshotBox(),
        HomeScreenSnapshotBox()
    )
    val recommendedBoxes = listOf(
        HomeScreenRecommendedBox(),
        HomeScreenRecommendedBox(),
        HomeScreenRecommendedBox(),
        HomeScreenRecommendedBox()
    )
}