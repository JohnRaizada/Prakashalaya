package com.example.prakashalay.ui.layout.drawers

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prakashalay.R
import com.example.prakashalay.data.repository.DataRepository
import com.example.prakashalay.navigation.Screen
import com.example.prakashalay.ui.layout.buttons.UserIconButton

@Composable
fun SideNavigationDrawer(
    navController: NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth(.7f)
            .defaultMinSize(263.dp, 505.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer),
        shape = RoundedCornerShape(0.dp,0.dp,30.dp,0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TopBox(navController = navController)
            MenuBox(navController = navController)
            BottomBox(
                modifier = Modifier,
                navController = navController
            )
        }
    }
}
@Composable
fun TopBox(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onTertiaryContainer)
    ) {
        Column() {
            Button(
                onClick = { navController.navigate(Screen.AboutScreen.route) },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
                shape = RoundedCornerShape(0.dp,20.dp,20.dp,0.dp),
                modifier = Modifier
                    .padding(0.dp,45.dp,0.dp,0.dp)
                    .wrapContentSize()
                    .defaultMinSize(100.dp,70.dp)
                    .requiredSize(100.dp,70.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = stringResource(
                                    R.string.theprakashalaya)
                                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                UserIconButton(
                    modifier = Modifier
                        .padding(0.dp,0.dp,15.dp,15.dp)
                        .wrapContentSize()
                        .defaultMinSize(56.dp,56.dp)
                        .requiredSize(56.dp,56.dp)
                        .align(Alignment.CenterVertically),
                    navController = navController
                )
            }
        }
    }
}
@Composable
fun MenuBox(
    modifier: Modifier = Modifier,
    navController: NavController
){
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(DataRepository.sideNavigationDrawerMenuItems) {
            Button(
                modifier = Modifier.wrapContentHeight(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                onClick = {
                    navController.navigate(it.navRoute)
                }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = stringResource(id = it.text),
                        modifier = Modifier
                            .defaultMinSize(22.dp)
                            .padding(30.dp, 15.dp, 15.dp, 0.dp)
                            .requiredSize(22.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        text = stringResource(id = it.text),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
@Composable
fun BottomBox(
    modifier: Modifier,
    navController: NavController
){
    val context = LocalContext.current
    Column(
        modifier = modifier
            .padding(29.dp, 72.dp, 77.dp, 13.dp)
    ) {
        Text(text = stringResource(R.string.alsoon))
        LazyRow {
            items(DataRepository.sideNavigationDrawerBottomItems) {
                val link = stringResource(it.link)
                IconButton(onClick = {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(link)
                        )
                    )
                }) {
                    Icon(painter = painterResource(id = it.iconRes), contentDescription = null)
                }
            }
        }
    }
}