package com.example.cmu_pratica2.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmu_pratica2.models.Question
import com.example.cmu_pratica2.ui.theme.CMU_pratica2Theme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun QuestionComponent(question: Question) {
    Row {
        var userInput: TextFieldValue by remember { mutableStateOf(TextFieldValue("")) }

        Text(text = "Insira o resultado de:\n ${question.x} + ${question.y} =", maxLines = 2)
        TextField(value = userInput,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(40.dp),
            onValueChange = {
                userInput = it
                if (it.text != "") {
                    question.answer = Integer.valueOf(it.text)
                }
            })
    }
}

@Composable
fun QuestionsAccuracy(questions:List<Question>) {
    val correct = questions.filter {
        it.answer == it.solution
    }
    val total = questions.size
    Text(text = "Percentagem de questoês corretas: $correct")
}

@Composable
fun QuestionHelp() {
    val mContext = LocalContext.current
    Button(onClick = { }) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CMU_pratica2Theme {
        Greeting("Android")
    }
}