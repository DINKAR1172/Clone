package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.loginandsignup.Model.Looklist
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.Model.looking
import com.example.loginandsignup.R

@Composable
fun look(navController: NavController,sharedPreferences: SharedPreferences){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            LinearProgressIndicator(
                progress = 1.0f, trackColor = Color.Gray, color = colorResource(
                    id = R.color.Pinkish
                ), modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
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
                    LazyDisplay(data = data)
                }
            }
        }
        Button(onClick = {navController.navigate(Screens.distance.Path)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Next", color = Color.White)
        }
    }
}
@Composable
fun LazyDisplay(data:looking){
    Card(modifier = Modifier
        .height(100.dp)
        .width(120.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = data.Image), contentDescription =null)
        }

        Text(text = data.type, color = Color.Black)
        
    }
}