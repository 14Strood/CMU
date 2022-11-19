package pt.ipp.estg.cmu_retrofit

import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.ipp.estg.cmu_retrofit.ui.components.UIComponnets.getPointsOfInterest
import pt.ipp.estg.cmu_retrofit.ui.model.POI
import pt.ipp.estg.cmu_retrofit.ui.rest_api.RetrofitHelper
import pt.ipp.estg.cmu_retrofit.ui.rest_api.TourPedidoApi
import pt.ipp.estg.cmu_retrofit.ui.screens.PointsListScreen
import pt.ipp.estg.cmu_retrofit.ui.theme.CMU_RetrofitTheme
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : ComponentActivity() {

    val networkWifiRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    var wifiConnection = false
    private val DEBUG_TAG = "NetworkStatusExample"

    val nerworkCallBack = object : NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            wifiConnection = true
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val unmeteres = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            wifiConnection = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val connManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        var isWifiConn: Boolean = false
        var isMoblieConn: Boolean = false
        connManager.allNetworks.forEach { network ->
            connManager.getNetworkInfo(network)?.apply {
                if (type == ConnectivityManager.TYPE_WIFI) {
                    isWifiConn = isWifiConn or isConnected
                }
                if (type == ConnectivityManager.TYPE_MOBILE) {
                    isMoblieConn = isMoblieConn or isConnected
                }
            }
        }
        Log.d(DEBUG_TAG, "wifi connected: $isWifiConn")
        Log.d(DEBUG_TAG, "moblie connected: $isMoblieConn")

        setContent {
            CMU_RetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PointsListScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val connManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connManager.requestNetwork(networkWifiRequest, nerworkCallBack)
    }

    override fun onStop() {
        super.onStop()
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CMU_RetrofitTheme {
        Greeting("Android")
    }
}