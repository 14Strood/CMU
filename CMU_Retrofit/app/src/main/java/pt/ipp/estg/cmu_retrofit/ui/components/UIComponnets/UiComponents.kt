package pt.ipp.estg.cmu_retrofit.ui.components.UIComponnets

import android.util.Log
import pt.ipp.estg.cmu_retrofit.ui.model.POI
import pt.ipp.estg.cmu_retrofit.ui.rest_api.RetrofitHelper
import pt.ipp.estg.cmu_retrofit.ui.rest_api.TourPedidoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getPointsOfInterest(location: String, category: String, name: String): List<POI> {
    val tourApi = RetrofitHelper.instance().create(TourPedidoApi::class.java)
    var points1: List<POI> = emptyList()

    tourApi.getPoints(location, category, name)
        .enqueue(object : Callback<List<POI>> {
            override fun onResponse(
                call: Call<List<POI>>,
                response: Response<List<POI>>
            ) {
                points1 = response.body()!!
                Log.i("NetworkStatusExample", points1.toString())
            }

            override fun onFailure(call: Call<List<POI>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    return points1
}