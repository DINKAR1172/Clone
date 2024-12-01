package com.example.loginandsignup.Model

data class SignINResult(val UserData:GoogleData?,val errorMessage:String?)
data class GoogleData(val Userid:String,
    val UserName:String?,
    val UserPictureUrl:String?)