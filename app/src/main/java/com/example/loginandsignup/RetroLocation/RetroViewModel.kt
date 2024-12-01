package com.example.loginandsignup.RetroLocation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RetroViewModel():ViewModel(){
    private var _retroresult=MutableLiveData<Result<RetroResLocation>>()
    val retroresult:LiveData<Result<RetroResLocation>> get() = _retroresult

fun getdata(pincode:String) = try {
    _retroresult.value=Result.loading
    viewModelScope.launch {
        val data= retrofitresponse.getlocation(pincode = pincode)
        _retroresult.value=Result.sucess(data)
    }
}
catch (e:Exception){
   _retroresult.value= Result.exception(e)
}
}