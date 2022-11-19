package com.example.cmu_pratica2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.cmu_pratica2.models.Question
import com.example.cmu_pratica2.ui.screens.MyWelcomeScreen
import com.example.cmu_pratica2.ui.screens.QuestionsScreen
import com.example.cmu_pratica2.ui.theme.CMU_pratica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMU_pratica2Theme {
                var showWelcomeScreen by remember{ mutableStateOf((true)) }
                var questions = remember{ mutableListOf<Question>(
                        Question(1, 1, 2, 0),
                        Question(1, 2, 3, 0)
                    )
                }

                if (showWelcomeScreen) {
                    MyWelcomeScreen(onclick = {showWelcomeScreen = false})
                } else {
                    QuestionsScreen(questions)
                }
            }
        }
    }
}

