package com.example.prakashalay.ui.screens.homescreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.data.models.api.account.login.SendLogin
import com.example.prakashalay.data.repository.DataRepository
import com.example.prakashalay.ui.layout.buttons.MenuIcon
import com.example.prakashalay.ui.layout.drawers.BottomNavigationDrawer
import com.example.prakashalay.ui.layout.drawers.SideNavigationDrawer
import com.example.prakashalay.ui.screens.loginscreen.LoginViewModel
import com.example.prakashalay.ui.theme.*
import com.google.accompanist.pager.*

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
){
    val scope = rememberSaveable{
        mutableStateOf(true)
    }
    if (scope.value) {
        scope.value = !scope.value
        LoginViewModel().login(
            context = LocalContext.current,
            sendLogin = SendLogin(
                username = "user",
                password = "password"
            )
        )
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            SideNavigationDrawer(navController)
                        },
        drawerState = drawerState) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .windowInsetsPadding(WindowInsets.statusBars)
            ) {
                MenuIcon(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
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
//
//@Composable
//private fun TextDesign(
//    modifier: Modifier = Modifier,
//    @StringRes textRes: Int = R.string.theprakashalaya,
//    fontSize: TextUnit = MaterialTheme.fontSize.h1
//){
//    Text(
//        text = stringResource(),
//        modifier = Modifier
//            .padding(
//                MaterialTheme.spacing.medium,
//                MaterialTheme.spacing.damnLarge,
//                MaterialTheme.spacing.default,
//                MaterialTheme.spacing.medium
//            ),
//        fontFamily = FontFamily.SansSerif
//    )
//}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
private fun BackgroundBox(
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column {
            Text(text = stringResource(R.string.goodmorning),
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.large,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default
                    ),
                fontSize = MaterialTheme.fontSize.subtitle1
            )

            Text(
                text = stringResource(R.string.wadewilson),
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default
                    ),
                fontSize = MaterialTheme.fontSize.h4
            )
            Text(
                text = stringResource(R.string.alerts),
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.damnLarge,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.medium
                    ),
                fontSize = MaterialTheme.fontSize.subtitle1
            )
            AlertBox(modifier = Modifier)
            Text(
                text = stringResource(R.string.snapshots),
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.damnLarge,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.medium
                    ),
                fontSize = MaterialTheme.fontSize.subtitle1
            )
            SnapshotBoxPane(
                pagerModifier =  Modifier.align(Alignment.CenterHorizontally),
                indicatorModifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
private fun SnapshotBoxPane(
    pagerModifier: Modifier,
    indicatorModifier: Modifier
){
    val pagerState = rememberPagerState()
    val items = DataRepository.homeScreenSnapshotBoxes
    val coroutineScope = rememberCoroutineScope()
    var its = rememberSaveable {
        mutableStateOf(0)
    }
    HorizontalPager(
        count = items.size,
        state = pagerState,
        modifier = pagerModifier
    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            its.value = it
//            Text(text = stringResource(items[it].dataCardText))
//        }
        SnapshotBox(
            imageRes = items[it].imageRes
        )
        its.value = it
    }
    HorizontalPagerIndicator(
        pagerState = pagerState,
        indicatorShape = MaterialTheme.shape.small,
        activeColor = Color.Red,
        modifier = indicatorModifier.padding(MaterialTheme.spacing.small)
    )
//    val coroutineScope = rememberCoroutineScope()
//    coroutineScope.launch {
//        pagerState.animateScrollToPage(page = 2)
//    }
}
@Composable
private fun SnapshotBox(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.flaps_snapshots_background,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.secondary,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
){
    Card(
        modifier = modifier
            .padding(8.dp, 12.dp, 8.dp, 101.dp)
            .defaultMinSize(344.dp, 300.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(color),
        shape = RoundedCornerShape(20.dp)
    ) {
        val expanded = rememberSaveable {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.medium
                    )
                    .fillMaxWidth(.5f)
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.flaps_snapshots),
                contentDescription = stringResource(R.string.expand),
                contentScale = ContentScale.FillBounds
            )

            Column {
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small
                        ),
                    text = stringResource(R.string.flapsallcaps),
                    fontSize = MaterialTheme.fontSize.overLine
                )
                Column(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Divider()

                    Image(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.medium,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            ),
                        painter = painterResource(id = R.drawable.flap_icon_snapshot),
                        contentDescription = stringResource(R.string.flapiconsnapshot),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.small,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.small
                            ),
                        text = stringResource(id = R.string.masterflap),
                        fontSize = MaterialTheme.fontSize.subtitle1
                    )
                    
                    Divider()

                    Row(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.small,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            )
                    ) {
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    5.dp,
                                    MaterialTheme.spacing.extraSmall,
                                    MaterialTheme.spacing.default
                                ),
                            text = stringResource(R.string.statusspacecolonspace),
                            fontSize = MaterialTheme.fontSize.subtitle2
                        )

                        Text(
                            modifier = modifier
                                .padding(

                                ),
                            text = stringResource(R.string.open),
                            fontSize = MaterialTheme.fontSize.h6,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    if (!expanded.value) {
                        IconButton(
                            onClick = { expanded.value = !expanded.value },
                            modifier = Modifier
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.expand_icon_g),
                                contentDescription = stringResource(R.string.expand)
                            )
                        }
                    }
                }
            }
        }
        if (expanded.value) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        SnapShotBoxExpandedRow(onValueChange = {})
                        SnapShotBoxExpandedRow(onValueChange = {})
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = stringResource(
                                R.string.open
                            ),
                            modifier = Modifier
                                .defaultMinSize(48.dp)
                                .requiredSize(48.dp)
                        )
                    }
                }
                IconButton(
                    onClick = { expanded.value = !expanded.value },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = stringResource(
                            R.string.collapse
                        )
                    )
                }
            }

        }
    }
}
@Composable
fun SnapShotBoxExpandedRow(
    checked: Boolean = false,
    textRes: Int = R.string.expand,
    onValueChange: (Boolean)->Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth(.5f)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(textRes),
        )
        Switch(
            checked = checked,
            onCheckedChange = onValueChange
        )
    }
}
@Composable
fun AlertBox(
    modifier: Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier,
//                .fillMaxWidth(.5f),
            horizontalAlignment = Alignment.End
        ) {
            MultiItemBox(
                modifier = Modifier
            )
            TwoItemBox(modifier = Modifier)
        }
        Column(
            modifier = Modifier,
//                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            ThirdLargeBox(modifier = Modifier)
            SecondLargeBox(modifier = Modifier)
        }
    }
}
@Composable
fun TwoItemBox(
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.tertiaryContainer,
){
    Card(
        modifier = modifier
            .defaultMinSize(180.dp, 91.dp)
            .requiredSize(205.dp, 100.dp)
            .padding(8.dp, 4.dp, 4.dp, 4.dp)
            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level1),
        shape = MaterialTheme.shape.midLarge
    ) {
        Column(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small
                )
        ) {
            Text(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.extraSmall,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small
                    ),
                text = stringResource(R.string.solarpanelallcaps),
                fontSize = MaterialTheme.fontSize.overLine
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider()

                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.panelsourcemode),
                    fontSize = MaterialTheme.fontSize.subtitle1
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.grid),
                    fontSize = MaterialTheme.fontSize.h5,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ThirdLargeBox(
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.tertiaryContainer
){
    Card(
        modifier = modifier
            .defaultMinSize(180.dp, 91.dp)
            .requiredSize(204.dp, 135.dp)
            .padding(4.dp, 0.dp, 4.dp, 4.dp)
            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level1),
        shape = MaterialTheme.shape.midLarge
    ) {
        Column(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small
                )
        ) {
            Text(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.extraSmall,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small
                    ),
                text = stringResource(R.string.batteryallcaps),
                fontSize = MaterialTheme.fontSize.overLine
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider()

                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.batterypowerleft),
                    fontSize = MaterialTheme.fontSize.subtitle1
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.extraSmall,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = "3h 14m",
                    fontSize = MaterialTheme.fontSize.h4,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.asperyourdailyusagepattern),
                    fontSize = MaterialTheme.fontSize.caption
                )
            }
        }
    }
}

@Composable
fun SecondLargeBox(
    modifier: Modifier,
     color: Color = MaterialTheme.colorScheme.primaryContainer
) {
    Card(
        modifier = modifier
            .defaultMinSize(168.dp, 180.dp)
            .requiredSize(206.dp, 172.dp)
            .padding(4.dp, 0.dp, 8.dp, 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
        shape = MaterialTheme.shape.midLarge
    ) {
        Column(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.default
                )
        ) {
            Text(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.extraSmall,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small
                    ),
                text = stringResource(R.string.weatherallcaps),
                fontSize = MaterialTheme.fontSize.overLine
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider()

                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.extraSmall,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = "29°",
                    fontSize = MaterialTheme.fontSize.h2,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.thunderstorn),
                    fontSize = MaterialTheme.fontSize.subtitle2,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.extraSmall,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small
                        ),
                    text = stringResource(R.string.mondaycommathreefebruary),
                    fontSize = MaterialTheme.fontSize.caption
                )

                Divider()

                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.extraSmall,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.updatedabouttwominutesago),
                    fontSize = MaterialTheme.fontSize.caption
                )
            }
        }
    }
}

@Composable
fun MultiItemBox(
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.primaryContainer
){
    Card(
        modifier = modifier
            .defaultMinSize(180.dp, 180.dp)
            .requiredSize(205.dp, 205.dp)
            .padding(8.dp, 0.dp, 4.dp, 4.dp)
            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
        shape = MaterialTheme.shape.midLarge
    ) {
        Column(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small
                )
        ) {
            Text(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.extraSmall,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small
                    ),
                text = stringResource(R.string.batteryallcaps),
                fontSize = MaterialTheme.fontSize.overLine
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider()

                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.todayspoweroutput),
                    fontSize = MaterialTheme.fontSize.subtitle1
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = "30W",
                    fontSize = MaterialTheme.fontSize.h3,
                    fontWeight = FontWeight.Medium
                )
                
                Divider()
                
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.aboveaverageat),
                    fontSize = MaterialTheme.fontSize.subtitle1
                )
                
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = stringResource(R.string.twentypercent),
                    fontSize = MaterialTheme.fontSize.h3,
                    fontWeight = FontWeight.Medium
                )
            }

        }
    }
}



//
//
//@Preview
//@Composable
//fun UiTesting(
//    modifier: Modifier = Modifier
//)
//{
//    Card(
//        modifier = modifier
//            .defaultMinSize(168.dp, 180.dp)
//            .requiredSize(168.dp, 180.dp)
//            .padding(8.dp, 8.dp, 8.dp, 8.dp)
//            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
//        shape = MaterialTheme.shape.extraLarge
//    ){
//        Row(
//        ){
//            Text(text = stringResource(R.string.yourtodaysoutput))
//        }
//    }
//}