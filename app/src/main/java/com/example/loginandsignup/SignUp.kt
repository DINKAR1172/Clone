package com.example.loginandsignup

import android.app.Activity.RESULT_OK
import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.NavHostController
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.GooglePresentation.Sign_in.GoogleSignin
import com.example.loginandsignup.Model.Screens
import kotlinx.coroutines.launch

@Composable
fun SignUp(navHostController: NavHostController,viewModel: ViewModel,GOOogleAuth:GoogleSignin,scope: LifecycleCoroutineScope,sharedPreferences: SharedPreferences){
    val editor=sharedPreferences.edit()
    var GoogleLogIN by remember {mutableStateOf(sharedPreferences.getBoolean(Shareprefff.GoogleSignIn.key,false))}
    val GoogleState=viewModel.GoogleState.collectAsStateWithLifecycle()
    val Lcontext= LocalContext.current
    if (GoogleLogIN==true){
        if (GoogleState.value.isSignINSucessful){
            Toast.makeText(Lcontext,"Sucessfully Sign IN",Toast.LENGTH_LONG).show()
            navHostController.navigate(Screens.user.Path)
        }
    }

    val launcher= rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult(), onResult ={res->
        if (res.resultCode == RESULT_OK){
            editor.putBoolean(Shareprefff.GoogleSignIn.key,true)
            editor.apply()
    scope.launch {
    val signinResult=GOOogleAuth.getSignInResultWithIntent(res.data?:return@launch)
        viewModel.OnsignINResult(signinResult)
      }

        }

    } )
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.Pinkish)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier= Modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
           /* Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription =null)
            }*/
            Text(text = "LINKUP", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.SansSerif, color = colorResource(
                id = R.color.Link
            ))
            Spacer(modifier = Modifier.height(10.dp))
            Divider(modifier = Modifier.fillMaxWidth(), color = colorResource(id = R.color.black), thickness = 3.dp)
            Text(text = "What You can find here ", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = colorResource(
                id = R.color.purple_700
            ))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.hearts_lover_svgrepo_com), contentDescription =null)
            Text(text = "Love", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = colorResource(
                id = R.color.purple_700
            ))
            Spacer(modifier = Modifier.height(5.dp))
            Image(painter = painterResource(id = R.drawable.valentine_business_svgrepo_com), contentDescription =null)
            Text(text = "Relationship", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = colorResource(
                id = R.color.purple_700
            ))
            Spacer(modifier = Modifier.height(5.dp))
            Image(painter = painterResource(id = R.drawable.candle_light_9070567), contentDescription =null)
            Text(text = "HookUps", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = colorResource(
                id = R.color.purple_700
            ))
            Divider(modifier = Modifier.fillMaxWidth(), color = colorResource(id = R.color.black), thickness = 4.dp)
        }
        Column {
            Text(text = "What are you waiting for? ", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = Color.White)
            Text(text = "Make The First Move? ", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = Color.White)
        }
        Column(modifier = Modifier.background(color = colorResource(id = R.color.Pinkish))){
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(colorResource(id = R.color.Pinkish))) {

        Button(onClick = {navHostController.navigate(Screens.Phonepage.Path)}, modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(Color.Green)) {

            Image(painter = painterResource(id = R.drawable.phone_svgrepo_com), contentDescription =null)
            Spacer(modifier = Modifier.width(150.dp))
            Text(text = "Sign in With Phone number", color = Color.Black)
        }
        Button(onClick = {scope.launch {
            val signinIntentsender=GOOogleAuth.signIn()
            launcher.launch(IntentSenderRequest.Builder(signinIntentsender?:return@launch).build())
        }
                         GoogleLogIN=true}, modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(Color.Green)) {

            Image(painter = painterResource(id = R.drawable.google), contentDescription =null)
            Spacer(modifier = Modifier.width(190.dp))
            Text(text = "Sign in With Google", color = Color.Black)
        }
        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(Color.Green)) {

            Image(painter = painterResource(id = R.drawable.facebook_1_svgrepo_com), contentDescription =null)
            Spacer(modifier = Modifier.width(170.dp))
            Text(text = "Sign in With facebook", color = Color.Black)
        }


    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top){
        TextButton(onClick = {navHostController.navigate(Screens.SignUpByEmail.Path)}) {
            Text(text = "Trouble in Sign in?", color = Color.Black)
        }
    }

}

    }


        }



