//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.example.prakashalay.R
//import com.example.prakashalay.ui.screens.roomscreen.SnapShotBoxExpandedRow
//import com.example.prakashalay.ui.theme.fontSize
//import com.example.prakashalay.ui.theme.spacing

package com.example.prakashalay.ui.screens.roomscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.prakashalay.R
import com.example.prakashalay.ui.theme.fontSize
import com.example.prakashalay.ui.theme.spacing

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
                MaterialTheme.spacing.default,
                MaterialTheme.spacing.large,
                MaterialTheme.spacing.small,
                MaterialTheme.spacing.damnLarge
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
                            painter = painterResource(id = R.drawable.expand_icon),
                            contentDescription = stringResource(R.string.expand)
                        )
                    }
                }
            }

            if (expanded.value) {
                Column {
                    Text(
                        modifier = modifier,
                        text = stringResource(R.string.adjustbrightness),
                        fontSize = MaterialTheme.fontSize.subtitle1
                    )
                }
            }
        }
    }
}