package pt.fbndr.cmu_pl_2.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.theme.CMU_PL_2Theme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun QuestionDisplay(question: Question, onChange:(question:Question)->Unit) {
    Column {
        Text(text = "Introduza o resultado de ${question.x} + ${question.y}:")
        Row {
            var input by remember { mutableStateOf(TextFieldValue("")) }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = input,
                onValueChange = {
                    input = it
                    if(!it.text.equals("")){
                        question.input = Integer.valueOf(it.text)
                    }
                } )
        }
    }
}



@Composable
fun QuestionHelp() {
    val mContext = LocalContext.current
    Button(onClick = {
        val myIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://pt.wikipedia.org/wiki/Adi%C3%A7%C3%A3o"))
        mContext.startActivity(myIntent)
    }) {
        Text(text = "Help me!")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CMU_PL_2Theme {
        Greeting("Android")
    }
}