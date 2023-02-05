package com.example.prakashalay.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val mini: Dp = 2.dp,
    val extraSmall: Dp = 4.dp,
    val oddSmall: Dp = 5.dp,
    val small: Dp = 8.dp,
    val semiSmall: Dp = 10.dp,
    val medium: Dp = 12.dp,
    val large: Dp = 16.dp,
    val someLarge: Dp = 20.dp,
    val howLarge: Dp = 24.dp,
    val semiLarge: Dp = 26.dp,
    val damnLarge: Dp = 28.dp,
    val extraLarge: Dp = 64.dp,
    val superLarge: Dp = 76.dp,
    val freakinLarge: Dp = 84.dp,
    val wowLarge: Dp = 96.dp,
    val sooooLarge: Dp = 104.dp,
    val mannnnLarge: Dp = 116.dp
)
val LocalSpacing = compositionLocalOf { Spacing() }
val MaterialTheme.spacing: Spacing
@Composable
@ReadOnlyComposable
get() = LocalSpacing.current