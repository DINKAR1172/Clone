package com.example.loginandsignup

import android.app.Activity
import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.Model.Result
import com.example.loginandsignup.Model.Screens

@Composable
fun PhonePage(viewModel: ViewModel,activity: Activity,navHostController: NavHostController,sharedPreferences: SharedPreferences){
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    var PSms by remember { mutableStateOf(0) }
    var email by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Email.key,null)) }
    var Phone by remember { mutableStateOf("") }
    val resultPhone by viewModel.PhoneSignIn.observeAsState()
    var displayotp by remember { mutableStateOf(false) }
    var otp by remember { mutableStateOf("") }
    val editor=sharedPreferences.edit()
    Scaffold(topBar = {TopAppBar(navigationIcon = { IconButton(onClick = {navHostController.navigateUp()}) {
        Icon(imageVector =Icons.Default.KeyboardArrowLeft, contentDescription =null, tint = Color.White)
    }},backgroundColor = colorResource(id = R.color.Orangess) , title = { Text(fontWeight = FontWeight.ExtraBold, fontSize = 40.sp,text = "Sign Up", color = Color.White)})}){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(color = colorResource(id = R.color.white)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top){
            Text(text = "Verify Your Phone Number", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = Color.Black)
            Spacer(modifier = Modifier.height(5.dp))
            Image(painter = painterResource(id = R.drawable.transaction_password_otp_verification_code_security_svgrepo_com), contentDescription =null)
            Spacer(modifier = Modifier.height(5.dp))
            if (PSms==0){
                Text(text = "Enter Mobile Number", color = Color.Gray)
            }
            else{
               Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                   Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                       Text(text = "We have send you an ", color = Color.Gray)
                       Text(
                           text = "One Time Password(OTP)",
                           color = Color.Black,
                           fontWeight = FontWeight.Bold
                       )
                   }
                   Text(text = "on this Mobile Number", color = Color.Gray)
               }

            }
            OutlinedTextField(prefix = { Text(text = "+91")},value =Phone, onValueChange ={Phone=it
                viewModel.setPhoneNumber(Phone)}, label = { Text(text = "Phone Number")} , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            Spacer(modifier = Modifier.height(5.dp))
            Button(shape = RectangleShape, modifier = Modifier.size(width = 200.dp, height = 50.dp),colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)),onClick = {PSms=1
                viewModel.CreateUserwithPhone(viewModel.Phonenumber.value.toString(),activity)
                displayotp=true}) {
                Text(text = "Sent otp", color = Color.White)
            }
            if (displayotp){
                    Text(text = "Enter the code from the sms we sent to ", color = Color.Gray)
                    Text(
                        text = "+91${Phone}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                Spacer(modifier = Modifier.height(5.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    OutlinedTextField(value =otp1, onValueChange ={otp1=it}, singleLine = true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
                        .size(50.dp)
                        .border(
                            BorderStroke(3.dp, color = Color.Black)
                        ))
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedTextField(value =otp2, onValueChange ={otp2=it}, singleLine = true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
                        .size(50.dp)
                        .border(
                            BorderStroke(3.dp, color = Color.Black)
                        ))
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedTextField(value =otp3, onValueChange ={otp3=it}, singleLine = true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
                        .size(50.dp)
                        .border(
                            BorderStroke(3.dp, color = Color.Black)
                        ))
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedTextField(value =otp4, onValueChange ={otp4=it}, singleLine = true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
                        .size(50.dp)
                        .border(
                            BorderStroke(3.dp, color = Color.Black)
                        ))
                }
                Spacer(modifier = Modifier.height(5.dp))
                Button(shape = RectangleShape, modifier = Modifier.size(width = 200.dp, height = 50.dp),colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)),onClick = {otp=otp1+otp2+otp3+otp4
                    viewModel.PhoneSignin(OTP = otp)
                    if(resultPhone is Result.Sucess){
                        editor.putString(Shareprefff.Phone.key,Phone)
                        editor.apply()
                        navHostController.navigate(Screens.Email.Path)
                    }
                }) {
                    Text(text = "Verifiy", color = Color.White)
                }
            }


        }
    }
    
}