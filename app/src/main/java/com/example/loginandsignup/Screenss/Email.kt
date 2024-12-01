package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R

@Composable
fun Email(navController:NavController,sharedPreferences: SharedPreferences){
    val editor =sharedPreferences.edit()
    var Email by remember { mutableStateOf("") }
    Scaffold(topBar = {
        TopAppBar(navigationIcon = { androidx.compose.material.IconButton(onClick = {navController.navigateUp()}) {
        androidx.compose.material.Icon(imageVector =Icons.Default.KeyboardArrowLeft, contentDescription =null, tint = Color.White)
    }
        },backgroundColor = colorResource(id = R.color.Orangess) , title = { Text(fontWeight = FontWeight.ExtraBold, fontSize = 40.sp,text = " Authentication", color = Color.White)})
    }){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(it), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            Column(horizontalAlignment = Alignment.CenterHorizontally){

                Text(
                    text = "  Authenticate Your email ",
                    color = colorResource(id = R.color.black),
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp
                )
                Image(painter = painterResource(id = R.drawable.email_svgrepo_com), contentDescription =null)
                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                    value = Email,
                    onValueChange = { Email = it },
                    label = { Text(text = "Enter Email") },
                    prefix = { Icon(imageVector = Icons.Default.Email, contentDescription =null)})
            }
            Button(onClick = {editor.putString(Shareprefff.Email.key,Email)
                editor.apply()
                navController.navigate(Screens.HomePage.Path)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Continue", color = Color.White)
            }
        }
    }

}