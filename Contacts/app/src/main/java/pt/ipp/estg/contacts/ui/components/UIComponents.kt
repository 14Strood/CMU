package pt.ipp.estg.contacts.ui.components

import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarContacts(image: Painter){

    Box(modifier = Modifier
        .height(250.dp)
        .fillMaxWidth()
    ){
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
            backgroundColor =  Color.Transparent,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
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
            modifier = Modifier.fillMaxSize().padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ali Connors", fontSize = 30.sp, color = Color.White)
        }
    }
}

@Composable
fun infoPhone(onclick: ()-> Unit, icon: ImageVector ,number: String, type: String) {
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
fun infoEmail(onclick: ()-> Unit, icon: ImageVector ,email: String, type: String) {
    Row {
        IconButton(onClick = onclick) {
            Icon(icon, null)
        }
        Text(text = email + "\n" + type, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

