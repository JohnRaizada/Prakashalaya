package com.example.prakashalay.ui.screens.homescreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.data.models.api.account.login.SendLogin
import com.example.prakashalay.data.repository.DataRepository
import com.example.prakashalay.ui.layout.buttons.MenuIcon
import com.example.prakashalay.ui.layout.drawers.BottomNavigationDrawer
import com.example.prakashalay.ui.layout.drawers.SideNavigationDrawer
import com.example.prakashalay.ui.screens.loginscreen.LoginViewModel
import com.example.prakashalay.ui.theme.elevation
import com.example.prakashalay.ui.theme.fontSize
import com.example.prakashalay.ui.theme.shape
import com.example.prakashalay.ui.theme.spacing
import com.google.accompanist.pager.*
import org.w3c.dom.Text

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
            TopBox(modifier = Modifier)
            Text(text = stringResource(R.string.snapshots))
            RecommendedBoxPane(
                pagerModifier =  Modifier.align(Alignment.CenterHorizontally),
                indicatorModifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
private fun RecommendedBoxPane(
    pagerModifier: Modifier,
    indicatorModifier: Modifier
){
    val pagerState = rememberPagerState()
    val items = DataRepository.recommendedBoxes
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
        SnapshotBox()
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
    imageRes: Int = R.drawable._5_,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
){
    Card(
        modifier = modifier
            .padding(8.dp, 12.dp, 8.dp, 101.dp)
            .defaultMinSize(344.dp, 160.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(color),
        shape = RoundedCornerShape(20.dp)
    ) {
        val expanded = rememberSaveable {
            mutableStateOf(false)
        }
        Column {
            Row() {
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(4.dp, 4.dp, 11.dp, 4.dp)
                        .defaultMinSize(206.dp, 100.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    painter = painterResource(id = imageRes),
                    contentDescription = stringResource(
                        id = stringRes
                    ),
                    contentScale = ContentScale.FillBounds
                )
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = iconRes),
                            contentDescription = stringResource(id = stringRes),
                            modifier = Modifier
                                .defaultMinSize(20.dp)
                                .requiredSize(20.dp)
                            ,
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = stringResource(id = stringRes),
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                    Text(
                        text = "15w",
                        fontSize = 48.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    if (!expanded.value) {
                        IconButton(
                            onClick = { expanded.value = !expanded.value },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = stringResource(R.string.expand)
                            )
                        }
                    }
                }
            }
            if (expanded.value){
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
                                                            R.string.open),
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
            .fillMaxWidth(.8f)
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
fun TopBox(
    modifier: Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.5f),
            horizontalAlignment = Alignment.End
        ) {
            MultiItemBox(modifier = Modifier)
            TwoItemBox(modifier = Modifier)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            TwoItemBox(modifier = Modifier)
            AlertsSecondBox(modifier = Modifier)
        }
    }
}
@Composable
fun TwoItemBox(
    modifier: Modifier
){
    Card(
        modifier = modifier
            .defaultMinSize(168.dp, 91.dp)
            .requiredSize(168.dp, 91.dp)
            .padding(8.dp, 8.dp,)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level1),
        shape = MaterialTheme.shape.extraLarge
    ) {
    }
}
@Composable
fun MultiItemBox(
    modifier: Modifier
){
    Card(
        modifier = modifier
            .defaultMinSize(168.dp, 180.dp)
            .requiredSize(168.dp, 180.dp)
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
        shape = MaterialTheme.shape.extraLarge
    ) {

    }
}

@Composable
fun AlertsSecondBox(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .defaultMinSize(168.dp, 180.dp)
            .requiredSize(168.dp, 180.dp)
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
        shape = MaterialTheme.shape.extraLarge
    ){
        Row(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.small
                )
        ){
            Text(
                text = stringResource(R.string.yourtodaysoutput),
                textAlign = TextAlign.Center
                )
        }
    }
}
@Preview
@Composable
fun UiTesting(
    modifier: Modifier = Modifier
)
{
    Card(
        modifier = modifier
            .defaultMinSize(168.dp, 180.dp)
            .requiredSize(168.dp, 180.dp)
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(MaterialTheme.elevation.level0),
        shape = MaterialTheme.shape.extraLarge
    ){
        Row(
        ){
            Text(text = stringResource(R.string.yourtodaysoutput))
        }
    }
}