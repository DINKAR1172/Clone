package com.example.loginandsignup.Model

sealed class Screens(var Path:String) {
    object firstpage:Screens("firstpage")
    object SignUpByEmail:Screens("SignUpByEmail")
    object SigninByEmail:Screens("SigninByEmail")
    object Phonepage:Screens("Phonepage")
    object HomePage:Screens("HomePage")
}