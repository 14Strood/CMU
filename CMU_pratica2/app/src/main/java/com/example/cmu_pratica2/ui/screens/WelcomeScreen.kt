package com.example.cmu_pratica2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cmu_pratica2.R

@Composable
fun MyWelcomeScreen(onclick: ()-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column() {
            Text(text = stringResource(id = R.string.welcome))
            Button(onClick = onclick) {
                Text(text = "NEXT")
            }
        }
    }
}