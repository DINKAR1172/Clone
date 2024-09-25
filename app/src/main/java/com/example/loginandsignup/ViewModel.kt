package com.example.loginandsignup

import android.app.Activity
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginandsignup.Model.AuthRepo
import com.example.loginandsignup.Model.Injection
import com.example.loginandsignup.Model.Result
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class ViewModel:ViewModel() {
    private val _PhoneSignup= MutableLiveData<Result<Boolean>>()
    val PhoneSignup:LiveData<Result<Boolean>> get()  =_PhoneSignup
    private val _PhoneSignIn= MutableLiveData<Result<Boolean>>()
    val PhoneSignIn:LiveData<Result<Boolean>> get()  =_PhoneSignIn
    private val _AuthsignUpResult= MutableLiveData<Result<Boolean>>()
    val AuthsignUpResult:LiveData<Result<Boolean>> get()  =_AuthsignUpResult
    private val _AuthsignINResult= MutableLiveData<Result<Boolean>>()
    val AuthsignINResult:LiveData<Result<Boolean>> get()  =_AuthsignINResult
    private val _repo:AuthRepo
    init {
        _repo= AuthRepo( Injection.instance(),FirebaseAuth.getInstance())
    }
    fun signUpByEmail(Email:String,Password:String,FirstName:String,LastName:String){
        viewModelScope.launch {
     _AuthsignUpResult.value=  _repo.SignUpByEmail(Email, Password, FirstName, LastName)
        }
    }
    fun signinByEmail(Email: String,Password: String){
        viewModelScope.launch {
           _AuthsignINResult.value= _repo.SignInByEmail(Email, Password)
        }
    }
    fun CreateUserwithPhone(Phone:String,activity: Activity){
        viewModelScope.launch {
          _PhoneSignup.value=  _repo.CreateUserWithPhone(Phone,activity)
        }
    }
    fun PhoneSignin(OTP:String){
        viewModelScope.launch {
            _PhoneSignIn.value=_repo.SignINWithPhoneOtp(OTP)
        }
    }

}