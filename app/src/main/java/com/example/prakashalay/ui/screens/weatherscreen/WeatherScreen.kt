package com.example.prakashalay.ui.screens.weatherscreen

import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.ui.layout.buttons.BackIconButton
import com.example.prakashalay.ui.layout.drawers.BottomNavigationDrawer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    navController: NavController
) {
    val weatherViewModel = WeatherViewModel()
    val WeatherUiState by weatherViewModel.uiState.collectAsState()
    val scope = rememberSaveable {
        mutableStateOf(true)
    }
    if (scope.value) {
        weatherViewModel.fetchWeatherDetails(LocalContext.current)
        scope.value = !scope.value
    }
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                BackIconButton(
                    navController = navController as NavHostController,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BackgroundImage(weatherViewModel = weatherViewModel)
            LineChart()
            BottomNavigationDrawer(
                navController = navController,
                modifier = Modifier.align(
                Alignment.BottomCenter)
            )
        }
    }
}
@Composable
private fun BackgroundImage(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel
){
    val imageResource = weatherViewModel.imageResourceDecider()
    Image(
        modifier = modifier
            .fillMaxSize(),
        painter = painterResource(id = imageResource), 
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}
@Composable
private fun SnapshotBox(
    modifier: Modifier = Modifier,
    weatherUiState: WeatherUiState
) {
    Column(
        modifier = modifier
    ) {
        Text(text = stringResource(id = weatherUiState.temperature))
        Text(text = weatherUiState.clear.toString())
        Text(text = weatherUiState.time.toString())
    }
}
@Composable
private fun DetailsBox(
    modifier: Modifier = Modifier,
    weatherUiState: WeatherUiState
){
    Column() {
        Row {
            InsightsBox()
            InsightsBox()
        }

    }
}
@Composable
private fun InsightsBox(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_launcher_background,
    topText: Int = R.string.app_name,
    bottomText: Int = R.string.app_name
) {
    Card(
        modifier=Modifier
    ) {
        Row() {
            Image(painter = painterResource(id = icon), contentDescription = stringResource(id = topText)
            )
            Column {
                Text(text = stringResource(id = topText))
                Text(text = stringResource(id = bottomText))
            }
        }
    }
}
@Composable
private fun LineChart() {
    Column(
        modifier = Modifier
            .padding(16.dp)
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