package com.example.prakashalay.ui.layout.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.prakashalay.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun RegistrationDialog(
    modifier: Modifier
) {
    val openDialog = rememberSaveable {
        mutableStateOf(true)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = !openDialog.value
                               },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        ) {
            Card(
                modifier = modifier
                    .defaultMinSize(316.dp,316.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onErrorContainer),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(R.string.oops))
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = stringResource(
                                            R.string.error)
                    )
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(R.string.register))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(R.string.login))
                    }
                }
            }
        }
    }
}