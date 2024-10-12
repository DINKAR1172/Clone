package com.example.loginandsignup.VM

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf


class VMM:androidx.lifecycle.ViewModel(){
    private var _Pi = mutableStateOf(0f)
    var pi:State<Float> =_Pi
    fun setPi(value:Float){
        _Pi.value+=value

    }
}