package pt.ipp.estg.contactsroom.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipp.estg.contactsroom.ui.models.ViewModels.ContactViewModel
import pt.ipp.estg.contactsroom.ui.models.database.ContactDataBase
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact

@Composable
fun ContactInsertScreen(onNavigateToContactsScreen:()->Unit) {

    val contactViewModel: ContactViewModel = viewModel()
    var contact = Contact("", "")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Insert Contact") },
                navigationIcon = {
                    IconButton(onClick = onNavigateToContactsScreen) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                var name by remember { mutableStateOf(TextFieldValue("")) }
                var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        name = it
                        if(it.text != ""){
                            contact.name = it.text
                        }
                    }
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                        if(it.text != ""){
                            contact.phoneNumber = it.text
                        }
                    }
                )
                Button(onClick = {
                    contactViewModel.insertContact(contact)
                    onNavigateToContactsScreen()
                }) {
                    Text(text = "Insert new Contact")
                }
            }
        }
    }

}