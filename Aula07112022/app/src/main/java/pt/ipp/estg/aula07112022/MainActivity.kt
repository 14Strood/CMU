package pt.ipp.estg.aula07112022

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.ipp.estg.aula07112022.model.POI
import pt.ipp.estg.aula07112022.rest_api.RetroFitHelper
import pt.ipp.estg.aula07112022.rest_api.TourDataApi
import pt.ipp.estg.aula07112022.ui.screens.ListPoints
import pt.ipp.estg.aula07112022.ui.theme.Aula07112022Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private val DEBUG_TAG = "NetworkStatusExample"

    var wifiConnection = false
    var isWifiConn = false
    var isMobileConn = false


    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            wifiConnection = true
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val unmetered = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            wifiConnection = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val connManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager

        connManager.allNetworks.forEach { network ->
            connManager.getNetworkInfo(network)?.apply {
                if (type == ConnectivityManager.TYPE_WIFI) {
                    isWifiConn = isWifiConn or isConnected
                }
                if (type == ConnectivityManager.TYPE_MOBILE) {
                    isMobileConn = isMobileConn or isConnected
                }
            }
        }

        Log.d(DEBUG_TAG, "Wifi connected: $isWifiConn")
        Log.d(DEBUG_TAG, "Mobile connected: $isMobileConn")

        setContent {
            Aula07112022Theme {
                ListPoints()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val connectivityManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, networkCallback)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Aula07112022Theme {
        Greeting("Android")
    }
}