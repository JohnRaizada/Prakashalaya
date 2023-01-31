package com.example.prakashalay.ui.screens.panelscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.prakashalay.R
import com.example.prakashalay.ui.layout.buttons.BackIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanelScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.solarpanel)) },
                navigationIcon = { BackIconButton(navController = navController) }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)){

        }
    }
}
@Composable
fun GraphBox(){

}
@Composable
fun SelectionBox(){

}
@Composable
fun ThreeItemBox(){
    
}