package com.example.prakashalay.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontSize(
    val h1: TextUnit = 96.sp,
    val h12: TextUnit = 74.sp,
    val h2: TextUnit = 60.sp,
    val h3: TextUnit = 48.sp,
    val h4: TextUnit = 34.sp,
    val h5: TextUnit = 24.sp,
    val h6: TextUnit = 20.sp,
    val subtitle1: TextUnit = 16.sp,
    val subtitle2: TextUnit = 14.sp,
    val caption: TextUnit = 12.sp,
    val overLine: TextUnit = 10.sp
    )
val LocalFontSize = compositionLocalOf { FontSize() }
val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current