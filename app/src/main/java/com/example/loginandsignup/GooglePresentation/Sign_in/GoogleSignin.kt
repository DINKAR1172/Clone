package com.example.loginandsignup.GooglePresentation.Sign_in

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.loginandsignup.Model.GoogleData
import com.example.loginandsignup.Model.SignINResult
import com.example.loginandsignup.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException

class GoogleSignin( private val context: Context,private val oneTapClient:SignInClient){
    private val _Auth=Firebase.auth
    suspend fun signIn():IntentSender?{
         val result =try {
            oneTapClient.beginSignIn(BeginSignRequest()).await()
        }
        catch (e:Exception){
            e.printStackTrace()
            if (e is CancellationException)
                throw e
                null

        }
        return result?.pendingIntent?.intentSender

    }
    suspend fun getSignInResultWithIntent(intent: Intent):SignINResult{
val credential=oneTapClient.getSignInCredentialFromIntent(intent)
   val googleidToken=credential.googleIdToken
        val googleCredentials=GoogleAuthProvider.getCredential(googleidToken,null)
  return  try {
val user=_Auth.signInWithCredential(googleCredentials).await().user
            SignINResult(UserData =user?.run {
                GoogleData(
                    Userid =uid,
                    UserName = displayName,
                    UserPictureUrl =photoUrl?.toString()
                )
            },errorMessage = null)
        }
        catch (e:Exception){
            e.printStackTrace()
            if (e is CancellationException)
                throw e
            SignINResult(UserData = null, errorMessage =e.message)
        }
    }
    suspend fun  signOut(){
        try {
oneTapClient.signOut().await()
            _Auth.signOut()
        }
        catch (e:Exception){
            e.printStackTrace()
            if (e is CancellationException) throw e

        }
    }
    fun getSignedinUser():GoogleData? =_Auth.currentUser?.run {
        GoogleData(
            Userid = uid,
            UserName = displayName,
            UserPictureUrl = photoUrl?.toString()
        )
    }
    private fun BeginSignRequest():BeginSignInRequest{
        return BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(
            GoogleIdTokenRequestOptions.builder().setSupported(true).setFilterByAuthorizedAccounts(false).setServerClientId(context.getString(R.string.Default_web_client_id)).build()
        ).setAutoSelectEnabled(true).build()
    }


}