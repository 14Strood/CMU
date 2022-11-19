package pt.fbndr.cmu_pl_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.components.Greeting
import pt.fbndr.cmu_pl_2.ui.components.MyAppNavHost
import pt.fbndr.cmu_pl_2.ui.components.ScaffoldExanple
import pt.fbndr.cmu_pl_2.ui.screens.QuestionsScreen
import pt.fbndr.cmu_pl_2.ui.screens.WelcomeScreen
import pt.fbndr.cmu_pl_2.ui.theme.CMU_PL_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMU_PL_2Theme {
                ScaffoldExanple()
            }
        }
    }
}

