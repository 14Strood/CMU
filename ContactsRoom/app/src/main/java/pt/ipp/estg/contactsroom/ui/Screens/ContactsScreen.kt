package pt.ipp.estg.contactsroom.ui.Screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipp.estg.contactsroom.ui.models.ViewModels.ContactViewModel
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import pt.ipp.estg.contactsroom.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsScreen(onNavigateToContact:(contact: Contact) -> Unit, onNavigateToContactInsert:() ->Unit) {

    val contactsViewModel: ContactViewModel = viewModel()
    val listContacts = contactsViewModel.allContacts.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact List") },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick =  onNavigateToContactInsert ) {
                        Icon(Icons.Filled.Add, contentDescription = "Localized description")
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 16.dp
            ),
            content = {
                listContacts.value?.let {
                    items(it) {
                        Card(modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                            elevation = 8.dp,) {
                            OutlinedButton(
                                onClick = { onNavigateToContact(it) }) {
                                Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
                                   /* Text(
                                            modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = "${it.name}\n${it.phoneNumber}"
                                    )*/
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_chair_96),
                                        contentDescription = "Living Room",
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        text = "Living Room")
                                /*
                                    Button(
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        onClick = {
                                            contactsViewModel.deleteContact(it)
                                        }) {
                                        Text(text = "DELETE")
                                    }*/
                                }
                            }
                        }
                    }
                }
            })
        }
    }
}

