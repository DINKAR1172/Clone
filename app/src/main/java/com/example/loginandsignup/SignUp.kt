package com.example.loginandsignup

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginandsignup.Model.Screens

@Composable
fun SignUp(navHostController: NavHostController){
    val context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.Pinkish)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "LINKUP", fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = Color.White)
       Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(colorResource(id = R.color.Pinkish))) {
           
           Button(onClick = {navHostController.navigate(Screens.Phonepage.Path)}, modifier = Modifier
               .fillMaxWidth()
               .height(60.dp)
               .padding(8.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(Color.White)) {

               Image(painter = painterResource(id = R.drawable.phone_svgrepo_com), contentDescription =null)
               Spacer(modifier = Modifier.width(120.dp))
               Text(text = "Sign in With Phone number", color = Color.Black)
           }


       }
        TextButton(onClick = {navHostController.navigate(Screens.SignUpByEmail.Path)}) {
            Text(text = "Trouble in Sign in ?", color = Color.White)
        }



            }


        }



