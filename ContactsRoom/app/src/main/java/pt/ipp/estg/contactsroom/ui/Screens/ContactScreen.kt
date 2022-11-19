package pt.ipp.estg.contactsroom.ui.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipp.estg.contactsroom.R
import pt.ipp.estg.contactsroom.ui.UIComponents.TopBarContacts
import pt.ipp.estg.contactsroom.ui.UIComponents.infoPhone
import pt.ipp.estg.contactsroom.ui.models.ViewModels.ContactViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun ContactScreen(contactId: Int, onNavigateToContactsScreen:()->Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val mcontext = LocalContext.current
        val contactViewModel: ContactViewModel = viewModel()
        val contact = contactViewModel.findOneContact(contactId).observeAsState().value

        Column {
            if (contact != null) {
                TopBarContacts(
                    painterResource(id = R.drawable.img),
                    contact.name,
                    onNavigateToContactsScreen
                )

                infoPhone({
                    val mIntent = Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:" + contact.phoneNumber)
                    )
                    mcontext.startActivity(mIntent)
                }, Icons.Filled.Call, contact.phoneNumber, "Mobile")
            }
        }
    }
}