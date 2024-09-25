package com.example.loginandsignup.Model

sealed class Result<out T> {
    data class Sucess<out T>(val data:T):Result<T>()
    data class Error(val Exception:Exception):Result<Nothing>()
}