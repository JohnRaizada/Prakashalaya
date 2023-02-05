package com.example.prakashalay.ui.screens.insightsscreen

import android.graphics.PointF
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.prakashalay.ui.layout.buttons.BackIconButton
import com.example.prakashalay.R
import com.example.prakashalay.ui.screens.weatherscreen.WeatherViewModel
import com.example.prakashalay.ui.theme.fontSize
import com.example.prakashalay.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsightsScreen(
    navController: NavHostController
){
    val insightsViewModel = InsightsViewModel()
    val insightsUiState by insightsViewModel.uiState.collectAsState()
    insightsViewModel.updateUiState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.insights),
                        fontSize = MaterialTheme.fontSize.h5
                    )
                        },
                navigationIcon = {
                    BackIconButton(
                        navController = navController
                    )
                }
            )
        }
    ) {
        com.example.prakashalay.ui.screens.insightsscreen.BackgroundBox(
            modifier = Modifier
                .padding(it),
            uiState = insightsUiState,
            viewModel = insightsViewModel
        )
    }
}

@Composable
private fun BackgroundBox(
    modifier: Modifier = Modifier,
    uiState: InsightsUiState,
    viewModel: InsightsViewModel
){
    LazyColumn(
        modifier = Modifier
    ){
        item{
            Battery(
                uiState = uiState,
                viewModel = viewModel
            )
        }
        item{
            SolarPanel(
            uiState = uiState,
            viewModel = viewModel
            )
        }
        item {
            WeatherForecast(
                uiState = uiState,
                viewModel = viewModel
            )
        }
        item{
            Brightness(
                uiState = uiState,
                viewModel = viewModel
            )
        }
    }
}

@Composable
private fun Battery(
    color: Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier,
    uiState: InsightsUiState,
    viewModel: InsightsViewModel
){
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.mannnnLarge,
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.damnLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.battery),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.extraSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
            )
        Card(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
                .defaultMinSize(344.dp, 260.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .requiredHeight(170.dp)
                    ,
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = modifier
                            .fillMaxSize(.35f)
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.damnLarge,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                            )
                            .align(Alignment.TopCenter),
                        color = MaterialTheme.colorScheme.tertiary,
                        trackColor = MaterialTheme.colorScheme.onTertiary,
                        strokeCap = StrokeCap.Round,
                        progress = uiState.progressBarValue
                    )

                    Text(
                        modifier = Modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.medium,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            ),
                        text = "37%",
                        fontSize = MaterialTheme.fontSize.h2,
                        fontWeight = FontWeight.Medium
                    )
                }
                Divider(
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default
                            ),
                            text = stringResource(R.string.batterystatus),
                            fontSize = MaterialTheme.fontSize.caption
                        )
                        Text(
                            modifier = Modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.extraSmall,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default
                                ),
                            text = stringResource(R.string.charging),
                            fontSize = MaterialTheme.fontSize.h5,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default
                                ),
                            text = stringResource(R.string.chargingtimeleft),
                            fontSize = MaterialTheme.fontSize.caption
                        )
                        Text(
                            modifier = Modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.extraSmall,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default
                                ),
                            text = uiState.chargingTimeLeft,
                            fontSize = MaterialTheme.fontSize.h5,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }


            }
        }

    }
}

@Composable
private fun SolarPanel(
    color: Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier,
    uiState: InsightsUiState,
    viewModel: InsightsViewModel
) {
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.damnLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.solarpanel),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.extraSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
        )

        Card(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
                .defaultMinSize(344.dp, 320.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    )
            ) {
                LineChart()

                Divider()

                Row(
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.large,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    SolarPanelText()
                    SolarPanelText(
                        time = stringResource(R.string.morning)
                    )
                    SolarPanelText(
                        time = stringResource(R.string.noon)
                    )
                    SolarPanelText(
                        time = stringResource(R.string.evening)
                    )
                    SolarPanelText()
                }

            }
        }
    }
}

@Composable
private fun SolarPanelText(
    modifier: Modifier = Modifier,
    time: String = stringResource(id = R.string.midnight)
){
    Text(
        text = time,
        fontSize = MaterialTheme.fontSize.subtitle2
    )
}

@Composable
private fun WeatherForecast(
    color: Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier,
    uiState: InsightsUiState,
    viewModel: InsightsViewModel
){
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.damnLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.weatherforecast),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.extraSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
        )
        Card(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
                .defaultMinSize(344.dp, 260.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = uiState.temperature,
                    fontSize = MaterialTheme.fontSize.h1,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    text = uiState.weatherStatus,
                    fontSize = MaterialTheme.fontSize.h6,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium
                        ),
                    text = uiState.dayAndDate,
                    fontSize = MaterialTheme.fontSize.caption
                )

                Divider()

                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium
                                ),
                            text = stringResource(R.string.weatheralerts),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        SnapshotBox()
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium
                                ),
                            text = stringResource(R.string.systemprotection),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )

                        SnapshotBox()
                    }
                }
            }
        }
    }
}

@Composable
private fun Brightness(
    color: Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier,
    uiState: InsightsUiState,
    viewModel: InsightsViewModel
) {
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.damnLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.brightness),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.extraSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
        )
        Card(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                )
                .defaultMinSize(344.dp, 280.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.default
                )
            ) {
                BrightnessRoofFlap()
                Divider()
                BrightnessRoomFlap(
                    room = stringResource(id = R.string.dining)

                )
                Divider()
                BrightnessRoomFlap(
                    room = stringResource(id = R.string.livingroom)

                )
                Divider()
                BrightnessRoomFlap(
                    room = stringResource(id = R.string.bedroom)

                )
            }
        }
    }
}


@Composable
private fun BrightnessRoofFlap(
    modifier: Modifier = Modifier
){
    Text(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.default
            ),
        text = stringResource(R.string.master),
        fontSize = MaterialTheme.fontSize.h6,
        fontWeight = FontWeight.Medium
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.medium,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.medium
            ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.outline_wb_sunny_24),
            contentDescription = stringResource(R.string.sunminimum)
        )
        LinearProgressIndicator(
            modifier = modifier
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.semiSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                ),
            progress = .7f,
            color = MaterialTheme.colorScheme.primaryContainer,
            trackColor = MaterialTheme.colorScheme.primary,
            strokeCap = StrokeCap.Round
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_wb_sunny_24),
            contentDescription = stringResource(R.string.sunmaximun)
        )
    }
}

@Composable
private fun BrightnessRoomFlap(
    modifier: Modifier = Modifier,
    room: String = stringResource(id = R.string.bedroom)
){
    Column() {
        Text(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                ),
            text = room,
            fontSize = MaterialTheme.fontSize.subtitle1,
            fontWeight = FontWeight.Medium
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium
                ),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.outline_wb_sunny_24),
                contentDescription = stringResource(R.string.sunminimum)
            )
            LinearProgressIndicator(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.semiSmall,
                        MaterialTheme.spacing.default,
                        MaterialTheme.spacing.default
                    ),
                progress = .7f,
                color = MaterialTheme.colorScheme.primaryContainer,
                trackColor = MaterialTheme.colorScheme.primary,
                strokeCap = StrokeCap.Round
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_wb_sunny_24),
                contentDescription = stringResource(R.string.sunmaximun)
            )
        }
    }


}

@Composable
private fun LineChart() {
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.default
            )
            .wrapContentSize(align = Alignment.BottomStart)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            val distance = size.width / (lineChartData().size + 1)
            var currentX = 0F
            val maxValue = lineChartData().maxOrNull() ?: 0
            val points = mutableListOf<PointF>()

            lineChartData().forEachIndexed { index, data ->
                if (lineChartData().size >= index + 2) {
                    val y0 = (maxValue - data) * (size.height / maxValue)
                    val x0 = currentX + distance
                    points.add(PointF(x0, y0))
                    currentX += distance
                }
            }
            for (i in 0 until points.size - 1) {
                drawLine(
                    start = Offset(points[i].x, points[i].y),
                    end = Offset(points[i + 1].x, points[i + 1].y),
                    color = Color(0xFF3F51B5),
                    strokeWidth = 8f
                )
            }
        }
    }
}
private fun lineChartData() = listOf(
    5929, 6898, 8961, 5674, 7122, 2092, 3427, 5520, 4680, 7418,
    4743, 4280, 12211, 7295, 9900, 12438, 11186, 5439, 4227, 5138,
    11015, 8386, 12450, 10411, 10852, 7782, 7371, 4983, 9234, 6847
)

@Composable
private fun SnapshotBox(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.flaps_snapshots_background,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.secondary,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
) {
    Card(
        modifier = modifier
            .padding(8.dp, 12.dp, 8.dp, 101.dp)
            .defaultMinSize(107.dp, 40.dp),
        colors = CardDefaults.cardColors(color),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary  )
    ) {
        val expanded = rememberSaveable {
            mutableStateOf(false)
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