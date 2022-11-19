package com.example.tourpediaexample

import com.example.tourpediaexample.models.POI
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