package com.example.prakashalay.ui.layout.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun UserIconButton(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = DrawerState(initialValue = DrawerValue.Closed),
    navController: NavController
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        onClick = {
            navController.navigate(Screen.ProfileScreen.route)
        }
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .requiredSize(56.dp)
                .defaultMinSize(56.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}