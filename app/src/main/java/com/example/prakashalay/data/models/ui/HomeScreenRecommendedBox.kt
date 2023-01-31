package com.example.prakashalay.data.models.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.prakashalay.R

data class HomeScreenRecommendedBox(
    @DrawableRes val imageRes: Int = R.drawable.ic_launcher_foreground,
    @DrawableRes val infoCardIcon: Int = R.drawable.ic_launcher_background,
    @DrawableRes val dataCardIcon: Int = R.drawable.ic_launcher_foreground,
    @StringRes val infoCardText: Int = R.string.app_name,
    @StringRes val dataCardText: Int = R.string.app_name,
)