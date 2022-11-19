package pt.fbndr.cmu_pl_2.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.fbndr.cmu_pl_2.models.Question
import pt.fbndr.cmu_pl_2.ui.theme.CMU_PL_2Theme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.fbndr.cmu_pl_2.ui.screens.QuestionScreen
import pt.fbndr.cmu_pl_2.ui.screens.QuestionsScreen
import pt.fbndr.cmu_pl_2.ui.screens.WelcomeScreen

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ScaffoldExanple() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Jogo Matematico")
            }
        },

        bottomBar = {},

        content = { MyAppNavHost() },

        drawerContent = {},

        floatingActionButton = {}
    )
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "welcomeScreen"
) {
    val questions = remember {
        mutableListOf(
            Question(1, 1,1,2),
            Question(2, 1,2,3),
            Question(3, 2,2,4),
        )
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("welcomeScreen") {
            WelcomeScreen(onNavigateToQuestionsList = {navController.navigate("questionsList") })
        }
        composable("questionsList") {
            QuestionsScreen(questions,  onNavigateToQuestion = fun(question: Question) {
                navController.navigate("questionList/${question.id}")
            }, onNavigateToWelcomeScreen = {navController.navigate("welcomeScreen") })
        }
        composable("questionList/{questionId}") {
            val questionId = it.arguments?.getString("questionId")
            questionId?.let {
                QuestionScreen(findQuestion(questions, questionId), onNavigateToQuestionsList = {navController.navigate("questionsList")})
            }
        }
    }
}

fun findQuestion(questions: MutableList<Question>, questionId: String): Question {
    for (question in questions) {
        if (question.id == questionId.toInt()) {
            return question
        }
    }
    return Question(0, 0,0,0)
}


@Composable
fun QuestionDisplay(question: Question, onNavigateToQuestion:()->Unit) {
    Column {
        Text(text = "O resultado de ${question.x} + ${question.y}?")
        if (question.input != -1) {
            Text(text = "Resposta incorreta, sua resposta foi ${question.input}")
        }
        Button(onClick = onNavigateToQuestion ) {
            Text(text = "Responder")
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