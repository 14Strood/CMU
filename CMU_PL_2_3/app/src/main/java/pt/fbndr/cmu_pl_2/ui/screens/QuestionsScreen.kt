package pt.fbndr.cmu_pl_2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.components.Greeting
import pt.fbndr.cmu_pl_2.ui.components.QuestionDisplay
import pt.fbndr.cmu_pl_2.ui.components.QuestionHelp

@Composable
fun QuestionsScreen(questions:List<Question>, onChange:(question:Question)->Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            for(question in questions){
                QuestionDisplay(question = question, onChange=onChange)
                Spacer(modifier = Modifier.padding(0.dp,10.dp))
            }
            QuestionHelp()
        }
    }
}

