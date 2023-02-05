package com.example.prakashalay.ui.layout.buttons

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.prakashalay.R

@Composable
fun BackIconButton(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    IconButton(
        modifier = modifier,
        onClick = {navController.navigateUp()}
    ) {
        Icon(painter = painterResource(R.drawable.back_arrow), contentDescription = stringResource(R.string.back))
    }
}