package pt.ipp.estg.cmu_retrofit.ui.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pt.ipp.estg.cmu_retrofit.ui.model.POI
import pt.ipp.estg.cmu_retrofit.ui.rest_api.RetrofitHelper
import pt.ipp.estg.cmu_retrofit.ui.rest_api.TourPedidoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var points1: List<POI> = emptyList()

@Composable
fun PointsListScreen() {

    getPointsOfInterest("London", "attraction", "Science")

    LazyColumn(){
        items(points1){ point->
            Text(text = point.location)
        }
    }
}

private fun getPointsOfInterest(location:String, category: String, name: String){
    val tourApi = RetrofitHelper.instance().create(TourPedidoApi::class.java)
    //var points: List<POI> = emptyList()

    tourApi.getPoints(location,category, name)
        .enqueue(object : Callback<List<POI>>{
            override fun onResponse(call: Call<List<POI>>, response: Response<List<POI>>) {
                points1 = response.body()!!
                Log.i("NetworkStatusExample", points1.toString())
            }

            override fun onFailure(call: Call<List<POI>>, t: Throwable) {
                Log.i("NetworkStatusExample", "FAIL")
            }

        })
}
