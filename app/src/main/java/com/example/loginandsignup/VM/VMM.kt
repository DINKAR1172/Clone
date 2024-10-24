package com.example.loginandsignup.VM

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList


class VMM:androidx.lifecycle.ViewModel(){
   private var _FileUriList= mutableListOf<Uri>()
    var FileUriList:MutableList<Uri> =_FileUriList
    fun setList(data:Uri){
        _FileUriList.add(data)
    }
    private var _Pi = mutableStateOf(0f)
    var pi:State<Float> =_Pi
    fun setPi(value:Float){
        _Pi.value+=value

    }
}