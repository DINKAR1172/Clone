package com.example.loginandsignup.Constant

sealed class Shareprefff(val key:String){
    object Email:Shareprefff("Email")
    object Phone:Shareprefff("Phone")
    object Name:Shareprefff("Name")
    object DateofBirth:Shareprefff("DateofBirth")
    object Gender:Shareprefff("Gender")
    object SO1:Shareprefff("SO1")
    object SO2:Shareprefff("SO2")
    object SO3:Shareprefff("SO3")
    object Intrest:Shareprefff("Intrest")
    object look:Shareprefff("Look")
    object distance:Shareprefff("Distance")
    object school:Shareprefff("School")
    object habit:Shareprefff("Habit")
}
