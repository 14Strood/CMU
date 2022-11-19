package com.example.cmu_pl0

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmu_pl0.ui.theme.CMUPL0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("CMU0", "onCreate");

        setContent {
            CMUPL0Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp, 20.dp), color = MaterialTheme.colors.background
                ) {
                    InputText()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CMU0", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CMU0", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CMU0", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CMU0", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CMU0", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CMU0", "onDestroy")
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun InputText() {
    var myInputValue by remember { mutableStateOf(TextFieldValue("")) }
    var mContext = LocalContext.current
    Column() {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Qual é a sigla da unidade curricular??"
        )
        Spacer(modifier = Modifier.padding(0.dp, 5.dp))
        TextField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = myInputValue,
            onValueChange = { myInputValue = it })
        Spacer(modifier = Modifier.padding(0.dp, 5.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                if (myInputValue.text.equals("cmu") || myInputValue.text.equals("CMU")) {
                    Toast.makeText(mContext, "Certo!!!!!", Toast.LENGTH_LONG).show()
                    mContext.startActivity(Intent(mContext, Activity2::class.java))
                } else {
                    Toast.makeText(mContext, "Errooooo!!!!!", Toast.LENGTH_LONG).show()
                }
            }) {
            Text(text = "Validate")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CMUPL0Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewInputText() {
    CMUPL0Theme {
        InputText()
    }
}