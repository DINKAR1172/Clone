package com.example.loginandsignup

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginandsignup.Model.Result
import com.example.loginandsignup.Model.Screens

@Composable
fun SignInByEmail(viewModel: ViewModel,navHostController: NavHostController,sharedPreferences: SharedPreferences){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var SEditor=sharedPreferences.edit()
    val AuthSignInResult by viewModel.AuthsignINResult.observeAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.Pinkish)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Sign In Screen", fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = Color.White)
        OutlinedTextField(value = viewModel.Email.value, onValueChange ={viewModel.setEmail(it)}, label = { Text(text = "Email") }, shape = CircleShape, modifier = Modifier.height(60.dp))
        OutlinedTextField(value =password , onValueChange ={password=it}, visualTransformation = PasswordVisualTransformation(),label = { Text(text = " Password") }, shape = CircleShape, modifier = Modifier.height(60.dp))
        Button(onClick = {viewModel.signinByEmail(viewModel.Email.value,password)
            if (AuthSignInResult is Result.Sucess){
                SEditor.putString("Email",viewModel.Email.value)
                SEditor.apply()
                viewModel.setEmail("")
                password=""
                navHostController.navigate(Screens.HomePage.Path)
            }
        }) {
            Text(text = "Login")
        }
    }
}