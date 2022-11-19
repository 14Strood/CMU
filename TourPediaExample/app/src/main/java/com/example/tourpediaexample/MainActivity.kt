package com.example.tourpediaexample

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tourpediaexample.models.POI
import com.example.tourpediaexample.ui.theme.TourPediaExampleTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
        var wifiConnection = false
        var points: List<POI> = emptyList()

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        private fun getPointsOfInterest(location:String, category: String, name: String){
            val tourApi = RetrofitHelper.getInstance().create(TourDataApi::class.java)
            //var points: List<POI> = emptyList()

            tourApi.getPointsOfInterest(location,category, name)
                .enqueue(object : Callback<List<POI>>{
                    override fun onResponse(call: Call<List<POI>>, response: Response<List<POI>>) {
                        points = response.body()!!
                        Log.i("NetworkStatusExample", points.toString())
                    }

                    override fun onFailure(call: Call<List<POI>>, t: Throwable) {
                    }

                })
        }


        private val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                wifiConnection = true
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                wifiConnection = false
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TourPediaExampleTheme {
                getPointsOfInterest("London", "attraction", "Science")

                LazyColumn(){
                    items(points){ point->
                        Text(text = point.location)
                    }
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()

        val connectivityManager =
            getSystemService(ConnectivityManager::class.java) as ConnectivityManager
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
    TourPediaExampleTheme {
        Greeting("Android")
    }
}