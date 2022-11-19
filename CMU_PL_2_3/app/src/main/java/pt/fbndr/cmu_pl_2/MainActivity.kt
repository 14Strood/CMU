package pt.fbndr.cmu_pl_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.components.Greeting
import pt.fbndr.cmu_pl_2.ui.screens.QuestionsScreen
import pt.fbndr.cmu_pl_2.ui.screens.WelcomeScreen
import pt.fbndr.cmu_pl_2.ui.theme.CMU_PL_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMU_PL_2Theme {
                var showWelcomeScreen by remember{ mutableStateOf(true) }
                val questions = remember {
                    mutableListOf(
                        Question(1,1,2,0),
                        Question(1,2,3,0),
                        Question(2,2,4,0),
                    )
                }

                if(showWelcomeScreen) {
                    WelcomeScreen({ -> showWelcomeScreen=false})
                }else{
                    QuestionsScreen(questions, onChange={
                            it -> for(q in questions){
                                if (q.x == it.x && q.y == it.y ){
                                    q.input = it.input
                                }
                    }

                    })
                }
            }
        }
    }
}

