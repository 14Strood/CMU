package pt.ipp.estg.contacts.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import pt.ipp.estg.contacts.R
import pt.ipp.estg.contacts.ui.components.TopBarContacts
import pt.ipp.estg.contacts.ui.components.infoEmail
import pt.ipp.estg.contacts.ui.components.infoPhone

@Composable
fun ContactScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val mcontext = LocalContext.current

        Column {
            TopBarContacts(painterResource(id = R.drawable.img))
            infoPhone({val mIntent = Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:925195028"))
                        mcontext.startActivity(mIntent)}, Icons.Filled.Call , "925192028", "Mobile")
            infoPhone({}, Icons.Filled.Call ,"255754598", "Home")
            infoPhone({}, Icons.Filled.Call ,"242232123", "Work")
            Divider(color = Color.LightGray)
            infoEmail({}, Icons.Filled.Email, "aliconnors22@gmail.com", "Personal")
            infoEmail({}, Icons.Filled.Email,"aliconnors22@estg.ipp.pt", "Work")
        }
    }
}