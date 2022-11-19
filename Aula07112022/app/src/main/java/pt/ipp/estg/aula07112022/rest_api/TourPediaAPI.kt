package pt.ipp.estg.aula07112022.rest_api

import pt.ipp.estg.aula07112022.model.POI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TourDataApi {
    @GET("getPlaces")
    fun getPointsOfInterest(
        @Query("location") location:String,
        @Query("category") category:String,
        @Query("name") name:String,
    ): Call<List<POI>>
}