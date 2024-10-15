package com.example.loginandsignup.Model

import android.net.Uri
import androidx.annotation.DrawableRes
import com.example.loginandsignup.R

data class Pic(val id:Int=0,
               @DrawableRes val SelectionImage:Int= R.drawable.image)
data class UU(val id: Int=0,val uri: Uri?=null)
val PhotoLis= mutableListOf<Pic>(
    Pic(0)
, Pic(1),
    Pic(2),
    Pic(3),
    Pic(4),
    Pic(5)
)
