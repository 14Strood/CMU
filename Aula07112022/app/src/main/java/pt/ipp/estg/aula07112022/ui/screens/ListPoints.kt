package pt.ipp.estg.aula07112022.ui.screens

import android.graphics.Point
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import pt.ipp.estg.aula07112022.model.POI
import pt.ipp.estg.aula07112022.rest_api.RetroFitHelper
import pt.ipp.estg.aula07112022.rest_api.TourDataApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var points: List<POI> = emptyList()

@Composable
fun ListPoints(){
    getPointsOfInterest("London", "Attraction", "Science")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background),
        ) {
                items(points) { item ->
                    Text("asdasd")
                }
        }
    }
}

private fun getPointsOfInterest(location: String, category: String, name: String) {
    val tourApi = RetroFitHelper.getInstance().create(TourDataApi::class.java)

    tourApi.getPointsOfInterest(location, category, name)
        .enqueue(object : Callback<List<POI>> {
            override fun onResponse(
                call: Call<List<POI>>,
                response: Response<List<POI>>
            ) {
                points = response.body()!!
                Log.i("NetworkStatusExample", "olaaaaa")
            }

            override fun onFailure(call: Call<List<POI>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
}