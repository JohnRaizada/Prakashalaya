package com.example.prakashalay.data.models.ui.drawers.sidenavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen

data class BottomBoxItem(
    @DrawableRes val iconRes: Int = R.drawable.ic_launcher_foreground,
    @StringRes val link: Int = R.string.FacebookLink
)
