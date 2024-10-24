package com.example.loginandsignup.Model

import android.net.Uri
import androidx.annotation.DrawableRes
import com.example.loginandsignup.R

data class Pic(val id:Int=0,
               val name:String,@DrawableRes val SelectionImage:Int= R.drawable.image)
data class UU(val id: Int=0,val uri: Uri?=null)
val PhotoLis= mutableListOf<Pic>(
    Pic(0, name = "First")
, Pic(1, name = "Second"),
    Pic(2,"Third"),
    Pic(3,"Fourth"),
    Pic(4,"Five"),
    Pic(5,"Six")
)
