package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.loginandsignup.Model.Looklist
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.Model.looking
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM

@Composable
fun look(navController: NavController,sharedPreferences: SharedPreferences,viewModel:VMM){
    val editor=sharedPreferences.edit()
     var selectedAns = remember { mutableStateOf(-1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            LinearProgressIndicator(
                progress =viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
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
                text = "What are you looking for?",
                color = colorResource(id = R.color.black),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp
            )
            Text(text = "All good if it changes .There is something for everyone.", color = Color.Gray)
            LazyHorizontalGrid(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),rows =GridCells.Fixed(2), verticalArrangement = Arrangement.SpaceBetween, horizontalArrangement =Arrangement.SpaceBetween){
                items(Looklist){data->
                    LazyDisplay(data = data,selectedAns)
                }
            }
        }
        Button(onClick = {editor.putString(Shareprefff.look.key, Looklist[selectedAns.value].type)
            editor.apply()
            navController.navigate(Screens.distance.Path)
                         viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Next", color = Color.White)
        }
    }
}
@Composable
fun LazyDisplay(data:looking,selectedAns:MutableState<Int>){
    Card(modifier = Modifier
        .height(100.dp)
        .width(120.dp)
        .clickable {selectedAns.value=data.id}, border =if (selectedAns.value==data.id){
            BorderStroke(2.dp, color = Color.Black)
        }
        else{
            BorderStroke(2.dp, color = Color.Transparent)
        }
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = data.Image), contentDescription =null)
        }

        Text(text = data.type, color = Color.Black)
        
    }
}