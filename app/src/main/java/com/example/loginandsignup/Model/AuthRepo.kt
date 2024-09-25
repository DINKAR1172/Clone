package com.example.loginandsignup.Model

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.tasks.await
import java.util.concurrent.TimeUnit

class AuthRepo(val store:FirebaseFirestore,val Auth:FirebaseAuth) {
    private lateinit var Verificationcode:String
    suspend fun SignUpByEmail(Email:String,Password:String,FirstName:String,LastName:String):Result<Boolean> =try {
        Auth.createUserWithEmailAndPassword(Email,Password).await()
        _SavetoFireStore(Users(Email, FirstName, LastName))
        Result.Sucess(true)
    }catch (e:Exception){
        Result.Error(e)
    }
     private suspend fun _SavetoFireStore(data:Users){
        store.collection("Users").document(data.Email).set(data).await()
    }
    suspend fun SignInByEmail(Email: String,Password: String):Result<Boolean> =try{
        Auth.signInWithEmailAndPassword(Email,Password)
        Result.Sucess(true)
    }catch (e:Exception){
        Result.Error(e)
    }
    suspend fun CreateUserWithPhone(Phone:String,activity: Activity):Result<Boolean> = try{
        val onverificationcallback=object :PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {

            }

            override fun onVerificationFailed(p0: FirebaseException) {
             Result.Error(p0)
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                Result.Sucess(true)
                Verificationcode=p0
            }

        }
val options=PhoneAuthOptions.newBuilder(Auth).setPhoneNumber("+91$Phone").setTimeout(60L,TimeUnit.SECONDS).setActivity(activity).setCallbacks(onverificationcallback).build()
   PhoneAuthProvider.verifyPhoneNumber(options)
        Result.Sucess(true)
    }catch (e:Exception){
Result.Error(e)
    }
    suspend fun SignINWithPhoneOtp(OTP:String):Result<Boolean> = try{
        val credential=PhoneAuthProvider.getCredential(Verificationcode,OTP)
       Auth.signInWithCredential(credential).addOnCompleteListener{
           if (it.isSuccessful){
               Result.Sucess(true)
           }
       }.addOnFailureListener{
           val e:Exception=Exception()
      Result.Error(Exception =e)
       }
        Result.Sucess(true)
    }catch (e:Exception){
        Result.Error(e)
    }
}