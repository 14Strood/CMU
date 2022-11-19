package pt.ipp.estg.contactsroom

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import pt.ipp.estg.contactsroom.ui.UIComponents.bottomBarWork
import pt.ipp.estg.contactsroom.ui.UIComponents.listarDivisoesCasa
import pt.ipp.estg.contactsroom.ui.UIComponents.topBarWork
import pt.ipp.estg.contactsroom.ui.models.enitities.Divisao
import pt.ipp.estg.contactsroom.ui.theme.ContactsRoomTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var lista: List<Divisao> = Arrays.asList(
                    Divisao("Living Room", R.drawable.ic_baseline_chair_96),
                    Divisao("Bath Room", R.drawable.ic_baseline_bathtub_96),
                    Divisao("Bed Room", R.drawable.ic_baseline_bed_96),
                    Divisao("Bath Room", R.drawable.ic_baseline_bathtub_96),
                    Divisao("Bed Room", R.drawable.ic_baseline_bed_96),
                    Divisao("Bath Room", R.drawable.ic_baseline_bathtub_96),
                    Divisao("Bed Room", R.drawable.ic_baseline_bed_96)
                )

                Scaffold(
                    topBar = { topBarWork() },
                    bottomBar = { bottomBarWork() },
                    content = {
                        Column() {
                            Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                                Text(
                                    fontSize = 30.sp,
                                    text = "Hello, ")
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp,
                                    text = "John!")
                            }

                            listarDivisoesCasa(lista = lista, onNagivateToDivision = {})
                        }

                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactsRoomTheme {
        Greeting("Android")
    }
}