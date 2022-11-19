package pt.ipp.estg.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pt.ipp.estg.contacts.ui.screens.ContactScreen
import pt.ipp.estg.contacts.ui.theme.ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsTheme {
                ContactScreen()
            }
        }
    }
}