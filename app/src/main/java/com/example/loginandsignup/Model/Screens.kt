package com.example.loginandsignup.Model

sealed class Screens(var Path:String) {
    object firstpage:Screens("firstpage")
    object SignUpByEmail:Screens("SignUpByEmail")
    object SigninByEmail:Screens("SigninByEmail")
    object Phonepage:Screens("Phonepage")
    object HomePage:Screens("HomePage")
    object Profile:Screens("Profile")
    object user:Screens("user")
    object  Email:Screens("Email")
    object  Mobile:Screens("Mobile")
    object  Name:Screens("Name")
    object  dob:Screens("dob")
    object  Sex:Screens("Sex")
    object  SO:Screens("SO")
    object Intrest:Screens("Intrest")
    object look:Screens("look")
    object distance:Screens("distance")
    object School:Screens("School")
    object habit:Screens("Habits")
    object Photos:Screens("Photos")

}