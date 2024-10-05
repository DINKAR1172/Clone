package com.example.loginandsignup

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
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
import java.time.LocalDateTime

class ViewModel:ViewModel() {
    private  val _name = mutableStateOf("")
    val name:State<String> =_name
    fun SetName(Name:String){
        _name.value=Name
    }
    private  val _Email = mutableStateOf<String>("")
    val Email:State<String> =_Email
    fun setEmail(Email:String){
        _Email.value=Email
    }
    private  val _Gender = mutableStateOf("")
    val Gender:State<String> =_Gender
    fun SetGender(Gender:String){
        _Gender.value=Gender
    }

    private  val _Phonenumber = mutableStateOf<Long?>(null)
    val Phonenumber:State<Long?> =_Phonenumber
    fun setPhoneNumber(Number:String){
        _Phonenumber.value=Number.toLongOrNull()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private  val _DateofBirth = mutableStateOf<Long?>(null)
    @RequiresApi(Build.VERSION_CODES.O)
    val DateofBirth:State<Long?> =_DateofBirth
    @RequiresApi(Build.VERSION_CODES.O)
    fun SetDoB(Dob:Long?){
_DateofBirth.value=Dob
    }

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