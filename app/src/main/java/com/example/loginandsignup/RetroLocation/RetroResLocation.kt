package com.example.loginandsignup.RetroLocation

data class RetroResLocation(
    val postcode: String,
    val country: String,
    val countryabbreviation: String,
    val places: List<Place>
)