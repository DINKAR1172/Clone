package com.example.loginandsignup.RetroLocation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

val retrofit=Retrofit.Builder().baseUrl("https://api.zippopotam.us/").addConverterFactory(GsonConverterFactory.create()).build()
val retrofitresponse= retrofit.create(ApiLocation::class.java)
interface ApiLocation {
    @GET("{countrycode}/{pincode}")
    suspend fun getlocation( @Path("countrycode") countrycode:String="IN",@Path("pincode") pincode:String):RetroResLocation

}