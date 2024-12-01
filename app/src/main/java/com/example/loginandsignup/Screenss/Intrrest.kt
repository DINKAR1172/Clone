package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
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
import androidx.compose.ui.res.painterResource
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
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                androidx.compose.material.IconButton(onClick = {
                    navController.navigateUp()
                    viewModel.setPi(-0.1f)
                }) {
                    androidx.compose.material.Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            backgroundColor = colorResource(id = R.color.Orangess),
            title = {
                Text(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 40.sp,
                    text = "Data Collection",
                    color = Color.White
                )
            })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(){
                LinearProgressIndicator(
                    progress = viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                        id = R.color.Pinkish
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Column {
                        Text(text = "Category", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "of", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "Interest?", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                    }
                    Image(painter = painterResource(id = R.drawable.love_svgrepo_com), contentDescription =null)
                }
                Button(onClick = {selectedButton=1
                    IntrestAns="Women"}, shape = CircleShape, modifier = Modifier.fillMaxWidth()
                        ,border =BorderStroke(2.dp, Color.Black), colors =if (selectedButton==1){
                    ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess))
                }else{
                    ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                }){
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Women", color = Color.Black)
                        Icon(painter = painterResource(id = R.drawable.female_svgrepo_com), contentDescription =null,tint = Color.Black)
                    }
                }
                Button(onClick = {selectedButton=2
                    IntrestAns="men"}, shape = CircleShape, modifier = Modifier.fillMaxWidth()
                    ,border =BorderStroke(2.dp, Color.Black), colors =if (selectedButton==2){
                        ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess))
                    }else{
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                    }) {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Men", color = Color.Black)
                        Icon(painter = painterResource(id = R.drawable.male_svgrepo_com), contentDescription =null,tint = Color.Black)
                    }
                }
                Button(onClick = {selectedButton=3
                    IntrestAns="Everyone"}, shape = CircleShape, modifier = Modifier.fillMaxWidth()
                    ,border =BorderStroke(2.dp, Color.Black), colors =if (selectedButton==3){
                        ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess))
                    }else{
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                    }) {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Everyone", color = Color.Black)
                        Icon(painter = painterResource(id = R.drawable.male_and_female_svgrepo_com), contentDescription =null,tint = Color.Black)
                    }
                }
            }
            Button(onClick = {
                editor.putString(Shareprefff.Intrest.key,IntrestAns)
                editor.apply()
                navController.navigate(Screens.look.Path)
                viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }

        }
    }

}