package pt.ipp.estg.cmu_retrofit.ui.rest_api

import pt.ipp.estg.cmu_retrofit.ui.model.POI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TourPedidoApi {

    @GET("getPlaces")
    fun getPoints(
        @Query("location") location:String,
        @Query("category") category:String,
        @Query("name") name:String,
    ): Call<List<POI>>

}