package com.example.prakashalay.ui.screens.flapscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.ui.layout.buttons.UserIconButton
import com.example.prakashalay.ui.layout.buttons.MenuIcon
import com.example.prakashalay.ui.layout.drawers.BottomNavigationDrawer
import com.example.prakashalay.ui.layout.drawers.SideNavigationDrawer

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlapScreen(
    navController: NavHostController
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(drawerContent = {
        SideNavigationDrawer(navController)
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    UserIconButton(
                        modifier = Modifier
                            .padding(0.dp, 33.dp, 33.dp, 0.dp)
                            .align(Alignment.TopEnd)
                            .size(56.dp),
                        navController = navController
                    )
                    MenuIcon(
                        modifier = Modifier
                            .padding(14.dp, 46.dp, 0.dp, 0.dp),
                        drawerState = drawerState
                    )
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                BackgroundBox(modifier = Modifier.align(Alignment.BottomCenter))
                BottomNavigationDrawer(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    navController = navController
                )
            }
        }
    }
}
@OptIn(ExperimentalAnimationGraphicsApi::class, ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
private fun BackgroundBox(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.63625f)
            .defaultMinSize(360.dp, 613.dp)
    ) {
        Column {
            val datetimepicker = rememberDatePickerState()
            DatePicker(datePickerState = datetimepicker)
            val state = rememberSaveable {
                mutableStateOf(false)
            }
            val painter = rememberAnimatedVectorPainter(
                animatedImageVector = AnimatedImageVector.animatedVectorResource(id = R.drawable.avd_anim),
                atEnd = state.value,
            )
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        state.value = !state.value
                    },
                painter = painter,
                contentDescription = null
            )
            Column {
                ContainerBox()
                Row {
                    SmallStatisticsBox()
                    SmallStatisticsBox()
                }
                Row {
                    SmallStatisticsBox()
                    SmallStatisticsBox()
                }
            }
        }
    }
}
@Composable
private fun MediumStatisticsBox(
    modifier: Modifier = Modifier,
    topText: Int = R.string.app_name,
    bottomText: Int = R.string.app_name,
    icon: Int = R.drawable.ic_launcher_foreground,
    color: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp)
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = color
    ) {
        Column() {
            Icon(
                modifier = Modifier,
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = topText)
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = topText),
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = bottomText)
            )
        }
    }
}
@Composable
private fun SmallStatisticsBox(
    modifier: Modifier = Modifier,
    topText: Int = R.string.app_name,
    bottomText: Int = R.string.app_name,
    icon: Int = R.drawable.ic_launcher_foreground,
    color: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp)
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = color
    ) {
        Column() {
            Icon(
                modifier = Modifier,
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = topText)
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = topText),
            )
        }
    }
}
@Composable
private fun ContainerBox(
    modifier: Modifier = Modifier,
    color: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp)
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = color
    ) {
        Row {
            Column() {
                SmallStatisticsBox()
                SmallStatisticsBox()
            }
            LargeStatisticsBox()
        }
    }
}

@Composable
private fun LargeStatisticsBox(
    modifier: Modifier = Modifier,
    topText: Int = R.string.app_name,
    middle1Text: Int = R.string.app_name,
    middle2Text1: Int = R.string.app_name,
    middle2Text2: Int = R.string.app_name,
    bottomText1: Int = R.string.app_name,
    bottomText2: Int = R.string.app_name,
    icon: Int = R.drawable.ic_launcher_foreground,
    color: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp)
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = color
    ) {
        Column {
            MediumStatisticsBox()
            MediumStatisticsBox()
        }
    }
}