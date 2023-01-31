package com.example.prakashalay.ui.layout.buttons

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prakashalay.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MenuIcon(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = DrawerState(initialValue = DrawerValue.Closed)
) {
    val scope  = rememberCoroutineScope()
//    val isVisible = rememberSaveable {
//        mutableStateOf(false)
//    }
//    val isRound = rememberSaveable{
//        mutableStateOf(false)
//    }
//    val transition = updateTransition(targetState = isRound.value, label = "")
//    val repeatable = rememberInfiniteTransition()
//    val color = repeatable.animateColor(
//        initialValue = Color.Red,
//        targetValue = Color.Green,
//        animationSpec = infiniteRepeatable(
//            animation = tween(2000),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
    Button(
        modifier = modifier,
//            .padding(20.dp, 20.dp, 0.dp, 20.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
//        colors = ButtonDefaults.buttonColors(contentColor = Color.Red),
        onClick = {
//            isVisible.value = !isVisible.value
//            isRound.value = !isRound.value
            scope.launch {
                drawerState.open()
            }
        }
    ) {
        Image(
            modifier = Modifier
                .requiredSize(37.dp)
                .defaultMinSize(37.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
//        val borderRadius = animateIntAsState(
//            targetValue = if (isRound.value) 70 else 30,
////            animationSpec = tween(
////                easing = FastOutLinearInEasing,
////                durationMillis = 1000
////            )
//            animationSpec = spring(
//                dampingRatio = Spring.DampingRatioHighBouncy,
//                stiffness = Spring.StiffnessLow
//            )
//        )
//        val borderRadius = transition.animateInt(
//            transitionSpec = { tween(2000) },
//            label = "borderRadius",
//            targetValueByState = {
//                if (it) 100 else 0
//            }
//        )
//        val color = transition.animateColor(
//            transitionSpec = { tween( 1000) },
//             label = "color",
//            targetValueByState = {
//                if (it) Color.Cyan else Color.Magenta
//            }
//        )
//        AnimatedVisibility(
//            visible = isVisible.value,
//            enter = slideInHorizontally() + fadeIn()
//        ) {
//            Icon(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(borderRadius.value)),
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = stringResource(
//                    id = R.string.app_name
//                )
//            )
//        }
//        Box(modifier = Modifier
////            .clip(RoundedCornerShape(borderRadius.value))
//            .background(color.value)
//            .size(200.dp))
//        AnimatedContent(
//            targetState = isVisible,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f),
//            content = {
//                if (it.value) {
//                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
//                } else {
//                    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
//                }
//            },
//            transitionSpec = {
//                slideInHorizontally(
//                    initialOffsetX = {
//                        -it
//                    }
//                ) with  slideOutHorizontally(
//                    targetOffsetX = {
//                        it
//                    }
//                )
////                fadeIn() with  fadeOut()
//            }
//        )
    }
}