package pt.fbndr.cmu_pl_2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pt.fbndr.cmu_pl_2.ui.components.Greeting

@Composable
fun WelcomeScreen(onclick:()->Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Greeting(name = "Hello World")
            Button(onClick = onclick) {
                Text("Next")
            }
        }

    }
}

