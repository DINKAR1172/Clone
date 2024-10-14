package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM
import com.google.gson.Gson

@Composable
fun intrrest(navController: NavController, sharedPreferences: SharedPreferences,viewModel:VMM) {
    val editor =sharedPreferences.edit()
    var selectedButton by remember { mutableStateOf(0)}
    var IntrestAns by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(8.dp)){
            LinearProgressIndicator(
                progress = viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                    id = R.color.Pinkish
                ), modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            IconButton(onClick = {navController.navigateUp()
                viewModel.setPi(-0.1f)}) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
            }
            Text(
                text = "Who are you intrested in seeing?",
                color = colorResource(id = R.color.black),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp
            )
            Button(onClick = {selectedButton=1
                             IntrestAns="Women"}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)), shape = CircleShape, modifier = Modifier.fillMaxWidth()
                , border =if (selectedButton==1){
                    BorderStroke(2.dp, Color.Black)
                }
                else{
                    BorderStroke(0.dp, Color.Transparent)
                }) {
                Text(text = "Women", color = Color.Black)
            }
            Button(onClick = {selectedButton=2
                IntrestAns="men"}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)), shape = CircleShape, modifier = Modifier.fillMaxWidth()
                , border =if (selectedButton==2){
                    BorderStroke(2.dp, Color.Black)
                }
                else{
                    BorderStroke(0.dp, Color.Transparent)
                }) {
                Text(text = "Men", color = Color.Black)
            }
            Button(onClick = {selectedButton=3
                IntrestAns="Everyone"}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)), shape = CircleShape, modifier = Modifier.fillMaxWidth()
                , border =if (selectedButton==3){
                    BorderStroke(2.dp, Color.Black)
                }
                else{
                    BorderStroke(0.dp, Color.Transparent)
                }) {
                Text(text = "Everyone", color = Color.Black)
            }
        }
            Button(onClick = {
                editor.putString(Shareprefff.Intrest.key,IntrestAns)
                editor.apply()
                navController.navigate(Screens.look.Path)
                             viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }

    }
}