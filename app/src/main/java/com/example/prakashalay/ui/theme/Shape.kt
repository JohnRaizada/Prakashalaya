package com.example.prakashalay.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Shape(
    val noRounding: RoundedCornerShape = RoundedCornerShape(0.dp),
    val extraSmall: RoundedCornerShape = RoundedCornerShape(4.dp),
    val extraSmallTop: RoundedCornerShape = RoundedCornerShape(4.dp,4.dp,0.dp,0.dp),
    val small: RoundedCornerShape = RoundedCornerShape(8.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(12.dp),
    val large: RoundedCornerShape = RoundedCornerShape(16.dp),
    val largeEnd: RoundedCornerShape = RoundedCornerShape(0.dp,16.dp,16.dp,0.dp),
    val largeTop: RoundedCornerShape = RoundedCornerShape(16.dp,16.dp,0.dp,0.dp),
    val extraLarge: RoundedCornerShape = RoundedCornerShape(28.dp),
    val extraLargeTop: RoundedCornerShape = RoundedCornerShape(28.dp,28.dp,0.dp,0.dp),
    val full: RoundedCornerShape = RoundedCornerShape(50),
)

val LocalShape = compositionLocalOf { Shape() }
val MaterialTheme.shape: Shape
    @Composable
    @ReadOnlyComposable
    get() = LocalShape.current