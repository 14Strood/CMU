package pt.fbndr.cmu_pl_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.components.QuestionDisplay
import pt.fbndr.cmu_pl_2.ui.components.QuestionHelp

@Composable
fun QuestionsScreen(questions:List<Question>, onNavigateToQuestion:(question: Question)->Unit, onNavigateToWelcomeScreen:()->Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column () {
            var count = 1
            for(question in questions){
                Text(text = "Quest $count")
                count++
                if (question.input == question.solution) {
                    Text(text = "Já respondeu corretamente")
                } else {
                    QuestionDisplay(question = question, onNavigateToQuestion = { onNavigateToQuestion(question) })
                }
                Spacer(modifier = Modifier.padding(0.dp,10.dp))
            }
            QuestionHelp()
            Spacer(modifier = Modifier.padding(0.dp,80.dp))
            Button(onClick = onNavigateToWelcomeScreen) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Voltar")
            }
        }
    }
}
