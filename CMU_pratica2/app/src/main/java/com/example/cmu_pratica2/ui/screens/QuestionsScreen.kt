package com.example.cmu_pratica2.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cmu_pratica2.models.Question
import com.example.cmu_pratica2.ui.components.QuestionComponent
import com.example.cmu_pratica2.ui.components.QuestionsAccuracy

@Composable
fun QuestionsScreen(questions:List<Question>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            for (question in questions) {
                QuestionComponent(question)
            }
            Spacer(modifier = Modifier.padding(0.dp, 10.dp))
            QuestionsAccuracy(questions = questions)
        }

    }
}