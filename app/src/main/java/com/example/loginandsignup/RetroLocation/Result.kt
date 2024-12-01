package com.example.loginandsignup.RetroLocation

import kotlin.Result

sealed class Result<out T> {
     object loading:com.example.loginandsignup.RetroLocation.Result<Nothing>()
    data class sucess<out T>(val data:T):com.example.loginandsignup.RetroLocation.Result<T>()
    data class exception(val e:Exception):com.example.loginandsignup.RetroLocation.Result<Nothing>()
}