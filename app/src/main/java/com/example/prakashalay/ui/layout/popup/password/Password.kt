package com.example.prakashalay.ui.layout.popup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prakashalay.R
import com.example.prakashalay.ui.layout.popup.password.PasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(
    modifier: Modifier
){
    val passwordUiState by PasswordViewModel().uiState.collectAsState()
    Card(
        modifier = modifier
            .defaultMinSize(346.dp,308.dp)
    ) {
        Column(
            modifier= Modifier
                .fillMaxSize()
        ) {
            Text(text = stringResource(R.string.password))
            var oldPassword by rememberSaveable{
                mutableStateOf("")
            }
            var newPassword by rememberSaveable{
                mutableStateOf("")
            }
            var newPasswordConfirmation by rememberSaveable{
                mutableStateOf("")
            }
            TextField(
                value =  oldPassword,
                onValueChange = {
                    passwordUiState.oldPassword = oldPassword
                }
            )
            TextField(
                value =  newPassword,
                onValueChange = {
                    passwordUiState.newPassword = newPassword
                }
            )
            TextField(
                value =  newPasswordConfirmation,
                onValueChange = {
                    passwordUiState.newPasswordConfirmation = newPasswordConfirmation
                }
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}