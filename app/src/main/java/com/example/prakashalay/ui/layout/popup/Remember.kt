package com.example.prakashalay.ui.layout.popup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prakashalay.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Remember(modifier: Modifier){
    Card(
        modifier = modifier
            .defaultMinSize(346.dp,308.dp)
    ) {
        Column(
            modifier=Modifier
                .fillMaxSize()
//                .imeNestedScroll()
//                .imePadding()
        ) {
            Text(text = stringResource(R.string.whatdoyouremember))
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.username))
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.password))
            }
        }
    }
}