package com.example.prakashalay.ui.layout.drawers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.prakashalay.R
import com.example.prakashalay.data.repository.DataRepository
import com.example.prakashalay.ui.theme.spacing


@Composable
fun BottomNavigationDrawer(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Card(
        modifier = modifier
            .width(410.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(10.dp, 0.dp, 10.dp, 10.dp)
            .requiredHeight(60.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.oddSmall,
                    MaterialTheme.spacing.default,
                    MaterialTheme.spacing.default
                ),
            horizontalArrangement = Arrangement.SpaceAround,

        ) {
            DataRepository.navigationDrawerItems.forEach {
                IconButton(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterVertically),
                    onClick = {
                        navController.navigate(it.navRoute)
                    }) {
                    Icon(
                        painter = painterResource(id = it.icon),
                        tint = if (currentRoute == it.navRoute) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.background
                        },
                        contentDescription = null
                    )
                }
            }
        }
    }
}