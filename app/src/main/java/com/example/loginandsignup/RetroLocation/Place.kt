package com.example.loginandsignup.RetroLocation

import androidx.compose.runtime.MutableState

data class Place(
    val placename: String,
    val longitude: String,
    val state: String,
    val stateabbreviation: String,
    val latitude: String
)
data class IT(val name:String, var isSelected:MutableState<Boolean>)