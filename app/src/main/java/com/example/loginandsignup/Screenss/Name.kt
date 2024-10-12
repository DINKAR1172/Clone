package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R

@Composable
fun Name(sharedPreferences: SharedPreferences,navController: NavController){
    
    var naming by remember { mutableStateOf("") }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
        Column {
            LinearProgressIndicator(progress =1.0f, trackColor =Color.Gray, color = colorResource(
                id = R.color.Pinkish
            ), modifier = Modifier
                .fillMaxWidth()
                .height(8.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription =null)
            }
            Text(text = "Whats Your first name ?", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
            OutlinedTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),value =naming, onValueChange ={naming=it}, placeholder = {Text(text = "Enter your name")})
            Text(text = "This is how it will appear on your profile.", color = Color.Gray)
            Text(text = "cannot change it later ", color = Color.Blue)
        }
        Button(onClick = {navController.navigate(Screens.dob.Path)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Next", color = Color.White)
        }

        }


}