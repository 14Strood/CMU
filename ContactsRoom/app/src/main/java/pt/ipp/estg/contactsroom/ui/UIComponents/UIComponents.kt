package pt.ipp.estg.contactsroom.ui.UIComponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.ipp.estg.contactsroom.ui.Screens.ContactInsertScreen
import pt.ipp.estg.contactsroom.ui.Screens.ContactScreen
import pt.ipp.estg.contactsroom.ui.Screens.ContactsScreen
import pt.ipp.estg.contactsroom.ui.models.enitities.Divisao

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = {
        },

        bottomBar = {},

        content = { },

        drawerContent = {},

        floatingActionButton = {}
    )
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "contactsScreen"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("contactsScreen") {
            ContactsScreen(
                onNavigateToContact = { navController.navigate("contactsScreen/${it.contactId}") },
                onNavigateToContactInsert = { navController.navigate("contactScreenInsert") })
        }
        composable("contactScreenInsert") {
            ContactInsertScreen(onNavigateToContactsScreen = { navController.navigate("contactsScreen") })
        }
        composable("contactsScreen/{contactId}") {
            val contactId = it.arguments?.getString("contactId")
            contactId?.let {
                ContactScreen(
                    contactId = contactId.toInt(),
                    onNavigateToContactsScreen = { navController.navigate("contactsScreen") })
            }
        }
    }
}

@Composable
fun TopBarContacts(image: Painter, name: String, onNavigateToContactsScreen: () -> Unit) {

    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = image,
            contentDescription = "background_image",
        )
        TopAppBar(
            elevation = 0.dp,
            title = {
                Text("Contacts")
            },
            backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = onNavigateToContactsScreen) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Edit, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.MoreVert, null)
                }
            })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name, fontSize = 30.sp, color = Color.White)
        }
    }
}

@Composable
fun infoPhone(onclick: () -> Unit, icon: ImageVector, number: String, type: String) {
    Row {
        IconButton(onClick = onclick) {
            Icon(icon, null)
        }
        Text(text = number + "\n" + type, modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.padding(110.dp, 0.dp))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Send, null)
        }
    }
}

@Composable
fun topBarWork() {
    TopAppBar(
        title = {},
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        }
    )
}

@Composable
fun bottomBarWork() {
    BottomAppBar(
        modifier = Modifier,
    ) {
        Icon(Icons.Filled.Home, null)
        Icon(Icons.Filled.Edit, null)
        Icon(Icons.Filled.Menu, null)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun listarDivisoesCasa(
    lista: List<Divisao>,
    onNagivateToDivision: (divisao: Divisao) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentPadding = PaddingValues(
            start = 24.dp,
            top = 16.dp,
            end = 24.dp,
            bottom = 16.dp
        ),
        content = {
            lista.let {
                items(it) {
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp,
                    ) {
                        OutlinedButton(
                            onClick = { onNagivateToDivision(it) }) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    painter = painterResource(id = it.icon),
                                    contentDescription = it.name,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Spacer(modifier = Modifier.padding(top = 16.dp))
                                Text(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = it.name
                                )
                            }
                        }
                    }
                }
            }
        })
}