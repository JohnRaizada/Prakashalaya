package com.example.prakashalay.data.models.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.prakashalay.R

data class HomeScreenSnapshotBox(
    @DrawableRes val imageRes: Int = R.drawable.ic_launcher_foreground,
    @StringRes val stringRes: Int = R.string.app_name,
    @DrawableRes val icon: Int = R.drawable.ic_launcher_foreground,
    val color: Color = Color.Blue
)
