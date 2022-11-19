package pt.fbndr.cmu_pl_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import pt.fbndr.cmu_pl_2.models.Question

@Composable
fun QuestionScreen(question: Question, onNavigateToQuestionsList: ()-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Text(text = "Introducer resultant ${question.x} + ${question.y}:")
            Row {
                var input by remember { mutableStateOf(TextFieldValue("")) }
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = input,
                    onValueChange = {
                        input = it
                        if(it.text != ""){
                            question.input = Integer.valueOf(it.text)
                        }
                    }
                )
            }
            if (question.input == question.solution) {
                Text(text = "Resposta certa")
            } else {
                Text(text = "Resposta errada")
            }
            Button(onClick = onNavigateToQuestionsList ) {
                Text(text = "Responder")
            }
        }
    }
}