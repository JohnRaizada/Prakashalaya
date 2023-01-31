package com.example.prakashalay.ui.layout.animations

import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import com.example.prakashalay.R
import com.example.prakashalay.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun Loading(navController: NavHostController){

    LaunchedEffect(key1 =true){
        delay(2500)
        navController.navigate(Screen.HomeScreen.route)
    }
    // to keep track if the animation is playing
    // and play pause accordingly
    var isPlaying by remember {
        mutableStateOf(true)
    }
    // for speed
    var speed by remember {
        mutableStateOf(1f)
    }

    // remember lottie composition ,which
    // accepts the lottie composition result
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.splash
            )
    )


    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,
//        clipSpec = LottieClipSpec.Progress(0f,.5f),

        // this makes animation to restart when paused and play
        // pass false to continue the animation at which is was paused
        restartOnPlay = false

    )
    LottieAnimation(composition = composition, progress = progress)
}