package com.example.prakashalay.ui.screens.batteryscreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.data.models.api.account.register.SendRegister
import com.example.prakashalay.ui.layout.buttons.BackIconButton
import com.example.prakashalay.ui.layout.drawers.BottomNavigationDrawer
import com.example.prakashalay.ui.screens.registerscreen.RegisterViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BatteryScreen(
    navController: NavHostController
){
    Scaffold(
       topBar = {
           Box(modifier = Modifier.fillMaxWidth()){
               BackIconButton(
                   navController = navController,
                   modifier = Modifier.align(Alignment.CenterStart
                   ))
           }
       }
    ) {
        val batteryViewModel = BatteryViewModel()
        val BatteryUiState by batteryViewModel.uiState.collectAsState()
//        batteryViewModel.fetchBatteryLevel(LocalContext.current)
        val scope = rememberSaveable{
            mutableStateOf(true)
        }
        if (scope.value) {
            RegisterViewModel().sendRegistrationData(
            context = LocalContext.current,
            sendRegister = SendRegister(
                username = "newuse",
                name = "name",
                gender = "gender",
                mobile_number = "mobile_number",
                date_of_birth = "2022-01-02",
                password = "password",
                email_address = "email@address.com",
                city = "city",
                country = "country"
            )
        )
            scope.value = !scope.value
        }
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column() {
                Text(text = stringResource(R.string.battery))
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
                Row {
                    Column {
                        SmallStatisticsBox()
                        SmallStatisticsBox()
                    }
                    ContainerBox()
                }
                Row {
                    MediumStatisticsBox()
                    MediumStatisticsBox()
                }
            }
            BottomNavigationDrawer(
                navController = navController, modifier = Modifier.align(
                Alignment.BottomCenter
            ))
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
            Text(
                modifier = Modifier,
                text = stringResource(id = bottomText)
            )
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
        Column() {
            Text(
                modifier = Modifier,
                text = stringResource(id = topText),
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = middle1Text)
            )
            Row() {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = middle2Text1),
                )
                Text(
                    modifier = Modifier,
                    text = stringResource(id = middle2Text2)
                )

            }
            Row() {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = bottomText1),
                )
                Text(
                    modifier = Modifier,
                    text = stringResource(id = bottomText2)
                )

            }
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
