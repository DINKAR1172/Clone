package com.example.loginandsignup

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginandsignup.Model.Result
import com.example.loginandsignup.Model.Screens

@Composable
fun PhonePage(viewModel: ViewModel,activity: Activity,navHostController: NavHostController){
    val resultPhone by viewModel.PhoneSignIn.observeAsState()
    var displayotp by remember { mutableStateOf(false) }
    var phone by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.Pinkish)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = "SignUp With Phone Number", fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = Color.White)
 OutlinedTextField(value =phone, onValueChange ={phone=it}, label = { Text(text = "Phone Number")} )
   Button(onClick = {viewModel.CreateUserwithPhone(phone,activity)
       displayotp=true}) {
       Text(text = "Sent otp", color = Color.White)
   }
        if (displayotp){
            OutlinedTextField(value = otp, onValueChange ={otp=it}, label = { Text(text = "Enter otp")})
           Button(onClick = {viewModel.PhoneSignin(OTP = otp)
               if(resultPhone is Result.Sucess){
                   navHostController.navigate(Screens.HomePage.Path)
               }
           }) {
               Text(text = "Verifiy", color = Color.White)
           }
        }


    }
}