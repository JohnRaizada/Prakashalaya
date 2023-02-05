package com.example.prakashalay.ui.screens.roomscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.ui.layout.buttons.BackIconButton
import com.example.prakashalay.ui.theme.Shape
import com.example.prakashalay.ui.theme.fontSize
import com.example.prakashalay.ui.theme.shape
import com.example.prakashalay.ui.theme.spacing
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.rooms),
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
        BackgroundBox(
            modifier = Modifier
                .padding(it)
        )
    }
}

@Composable
private fun BackgroundBox(
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier

    ){
        item{MasterFlap()}
//        item{
//            Text(
//                text = stringResource(id = R.string.rooms),
//                fontSize = MaterialTheme.fontSize.subtitle1,
//                modifier = modifier
//                    .padding(
//                        MaterialTheme.spacing.medium,
//                        MaterialTheme.spacing.damnLarge,
//                        MaterialTheme.spacing.default,
//                        MaterialTheme.spacing.medium
//                    )
//            )
//        }
        item{RoomFlap()}
        item{RoomFlapRest(stringRes = R.string.bedroom)}
        item{RoomFlapRest(stringRes = R.string.dining)}
    }
}

@Composable
private fun MasterFlap(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.ic_launcher_background,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.secondary,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
) {
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.large,
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.damnLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.masterflap),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium
                )
        )
        Card(
            modifier = modifier
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .defaultMinSize(344.dp, 120.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            val expanded = rememberSaveable {
                mutableStateOf(false)
            }
            Column(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    )
            ) {
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                        ),
                    text = stringResource(id = R.string.masterflapone),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    thickness = 1.dp
//                    color = Color.Black
                )
                Row(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.flapangle),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default,
                                ),
                            text = "45°",
                            fontSize = MaterialTheme.fontSize.h4,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.estimatedintensity),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Row() {
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.medium,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default,
                                    ),
                                text = "30000",
                                fontSize = MaterialTheme.fontSize.h4,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.semiLarge,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default
                                    ),
                                text = stringResource(R.string.lux),
                                fontSize = MaterialTheme.fontSize.subtitle1
                            )
                        }
                    }
                }
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.large,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                )

                if (!expanded.value) {
                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expand_icon_g),
                            contentDescription = stringResource(R.string.expand)
                        )
                    }
                }
            }

            if (expanded.value) {
                Column(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                ) {
                    Text(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.small,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            ),
                        text = stringResource(R.string.adjustbrightness),
                        fontSize = MaterialTheme.fontSize.subtitle1
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.medium,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
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

                    Divider(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.large,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            )
                    )

                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.contract_icon_g),
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
private fun RoomFlap(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.ic_launcher_background,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.secondary,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
) {
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.large,
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.large
            )
    ) {
        Text(
            text = stringResource(id = R.string.roomflap),
            fontSize = MaterialTheme.fontSize.h6,
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.small,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.medium
                )
        )
        Card(
            modifier = modifier
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .defaultMinSize(344.dp, 120.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            val expanded = rememberSaveable {
                mutableStateOf(false)
            }
            Column(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    )
            ) {
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                    ),
                    text = stringResource(id = R.string.livingroom),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                    ),
                    thickness = 1.dp
//                    color = Color.Black
                )
                Row(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.flapangle),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default,
                            ),
                            text = "45°",
                            fontSize = MaterialTheme.fontSize.h4,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.estimatedintensity),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Row() {
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.medium,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default,
                                    ),
                                text = "30000",
                                fontSize = MaterialTheme.fontSize.h4,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.semiLarge,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default
                                    ),
                                text = stringResource(R.string.lux),
                                fontSize = MaterialTheme.fontSize.subtitle1
                            )
                        }
                    }
                }
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.large,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                )

                if (!expanded.value) {
                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expand_icon_g),
                            contentDescription = stringResource(R.string.expand)
                        )
                    }
                }
            }

            if (expanded.value) {
                Column(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                    )
                ) {
                    Text(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.small,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            ),
                        text = stringResource(R.string.adjustbrightness),
                        fontSize = MaterialTheme.fontSize.subtitle1
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.medium,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
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

                    Divider(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.large,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            )
                    )

                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.contract_icon_g),
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

//@Composable
//private fun SnapshotBox(
//    modifier: Modifier = Modifier,
//    imageRes: Int = R.drawable.ic_launcher_background,
//    stringRes: Int = R.string.app_name,
//    color: Color = MaterialTheme.colorScheme.secondary,
//    iconRes: Int = R.drawable.ic_launcher_background,
//    checked: Boolean = true
//){
//    Card(
//        modifier = modifier
//            .padding(
//                MaterialTheme.spacing.medium,
//                MaterialTheme.spacing.default,
//                MaterialTheme.spacing.medium,
//                MaterialTheme.spacing.damnLarge
//            )
//            .defaultMinSize(344.dp, 160.dp)
//            .fillMaxWidth(),
//        colors = CardDefaults.cardColors(color),
//        shape = RoundedCornerShape(20.dp)
//    ) {
//        val expanded = rememberSaveable {
//            mutableStateOf(false)
//        }
//        Column {
//            Row() {
//                Image(
//                    modifier = Modifier
//                        .padding(4.dp, 4.dp, 11.dp, 4.dp)
//                        .defaultMinSize(206.dp, 100.dp)
//                        .clip(RoundedCornerShape(15.dp)),
//                    painter = painterResource(id = imageRes),
//                    contentDescription = stringResource(
//                        id = stringRes
//                    ),
//                    contentScale = ContentScale.FillBounds
//                )
//                Column() {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(0.dp, 10.dp, 0.dp, 0.dp)
//                    ) {
//                        Image(
//                            painter = painterResource(id = iconRes),
//                            contentDescription = stringResource(id = stringRes),
//                            modifier = Modifier
//                                .defaultMinSize(20.dp)
//                                .requiredSize(20.dp)
//                            ,
//                            contentScale = ContentScale.FillBounds
//                        )
//                        Text(
//                            text = stringResource(id = stringRes),
//                            fontSize = 10.sp,
//                            textAlign = TextAlign.Center,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                        )
//                    }
//                    Text(
//                        text = "15w",
//                        fontSize = 48.sp,
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.ExtraBold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    )
//                    if (!expanded.value) {
//                        IconButton(
//                            onClick = { expanded.value = !expanded.value },
//                            modifier = Modifier.align(Alignment.CenterHorizontally)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_launcher_background),
//                                contentDescription = stringResource(R.string.expand)
//                            )
//                        }
//                    }
//                }
//            }
//            if (expanded.value){
//                Column {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Column() {
//
//                        }
//                        IconButton(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier
//                                .padding()
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_launcher_background),
//                                contentDescription = stringResource(
//                                    R.string.open),
//                                modifier = Modifier
//                                    .defaultMinSize(48.dp)
//                                    .requiredSize(48.dp)
//                            )
//                        }
//                    }
//                    IconButton(
//                        onClick = { expanded.value = !expanded.value },
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_launcher_background),
//                            contentDescription = stringResource(
//                                R.string.collapse
//                            )
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//@Composable
//fun SnapShotBoxExpandedRow(
//    checked: Boolean = false,
//    textRes: Int = R.string.expand,
//    onValueChange: (Boolean)->Unit,
//    modifier: Modifier = Modifier
//){
//    Row(
//        modifier = modifier
//            .fillMaxWidth(.8f)
//            .padding(10.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = stringResource(textRes),
//        )
//        Switch(
//            checked = checked,
//            onCheckedChange = onValueChange
//        )
//    }
//}

@Composable
private fun RoomFlapRest(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.ic_launcher_background,
    stringRes: Int = R.string.app_name,
    color: Color = MaterialTheme.colorScheme.secondary,
    iconRes: Int = R.drawable.ic_launcher_background,
    checked: Boolean = true
){
    Column(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.large,
                MaterialTheme.spacing.extraSmall,
                MaterialTheme.spacing.large
            )
    ) {
//        Text(
//            text = stringResource(id = R.string.roomflap),
//            fontSize = MaterialTheme.fontSize.h6,
//            modifier = Modifier
//                .padding(
//                    MaterialTheme.spacing.small,
//                    MaterialTheme.spacing.default,
//                    MaterialTheme.spacing.default,
//                    MaterialTheme.spacing.medium
//                )
//        )
        Card(
            modifier = modifier
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .defaultMinSize(344.dp, 120.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(color),
            shape = RoundedCornerShape(20.dp)
        ) {
            val expanded = rememberSaveable {
                mutableStateOf(false)
            }
            Column(
                modifier = modifier
                    .padding(
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.small,
                        MaterialTheme.spacing.default
                    )
            ) {
                Text(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default,
                        ),
                    text = stringResource(stringRes),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        ),
                    thickness = 1.dp
//                    color = Color.Black
                )
                Row(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.medium,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.flapangle),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Text(
                            modifier = modifier
                                .padding(
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.medium,
                                    MaterialTheme.spacing.default,
                                    MaterialTheme.spacing.default,
                                ),
                            text = "45°",
                            fontSize = MaterialTheme.fontSize.h4,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.estimatedintensity),
                            fontSize = MaterialTheme.fontSize.subtitle1
                        )
                        Row() {
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.medium,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default,
                                    ),
                                text = "30000",
                                fontSize = MaterialTheme.fontSize.h4,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = modifier
                                    .padding(
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.semiLarge,
                                        MaterialTheme.spacing.default,
                                        MaterialTheme.spacing.default
                                    ),
                                text = stringResource(R.string.lux),
                                fontSize = MaterialTheme.fontSize.subtitle1
                            )
                        }
                    }
                }
                Divider(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.large,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                )

                if (!expanded.value) {
                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expand_icon_g),
                            contentDescription = stringResource(R.string.expand)
                        )
                    }
                }
            }

            if (expanded.value) {
                Column(
                    modifier = modifier
                        .padding(
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.small,
                            MaterialTheme.spacing.default,
                            MaterialTheme.spacing.default
                        )
                ) {
                    Text(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.small,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            ),
                        text = stringResource(R.string.adjustbrightness),
                        fontSize = MaterialTheme.fontSize.subtitle1
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.medium,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
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

                    Divider(
                        modifier = modifier
                            .padding(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.large,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default
                            )
                    )

                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.contract_icon_g),
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