package com.example.loginandsignup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginandsignup.Model.Result
import com.example.loginandsignup.Model.Screens

@Composable
fun SignUpByEmail(viewModel: ViewModel,navHostController: NavHostController){
    var email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    var FirstName by remember { mutableStateOf("") }
    var LastName by remember { mutableStateOf("") }
     val AuthResult by viewModel.AuthsignUpResult.observeAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.Pinkish)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement =Arrangement.Center) {
        Text(text = "Sign Up Screen", fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = Color.White)
        OutlinedTextField(value =email , onValueChange ={email=it}, label = { Text(text = "Email")}, shape = CircleShape, modifier = Modifier.height(60.dp))
        OutlinedTextField(value =Password , onValueChange ={Password=it}, visualTransformation =PasswordVisualTransformation(),label = { Text(text = " Password")}, shape = CircleShape, modifier = Modifier.height(60.dp))
        OutlinedTextField(value =FirstName , onValueChange ={FirstName=it}, label = { Text(text = " First Name")}, shape = CircleShape, modifier = Modifier.height(60.dp))
        OutlinedTextField(value =LastName, onValueChange ={LastName=it}, label = { Text(text = " Last Name")}, shape = CircleShape, modifier = Modifier.height(60.dp))
        Button(onClick = {viewModel.signUpByEmail(email,Password,FirstName,LastName)
            email=""
            Password=""
            FirstName=""
            LastName=""
            if (AuthResult is Result.Sucess){
                navHostController.navigate(Screens.SigninByEmail.Path)
            }}) {
            Text(text = "SignUp")
        }
        TextButton(onClick = {navHostController.navigate(Screens.SigninByEmail.Path)}) {
            Text(text = "Already have an account", color = Color.White)
        }
    }
}