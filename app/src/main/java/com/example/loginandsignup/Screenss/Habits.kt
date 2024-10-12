package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Habits(navController: NavController,sharedPreferences: SharedPreferences){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
                text = "Lets talk lifestyle habits",
                color = colorResource(id = R.color.black),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp
            )
            Text(text = "Do their habits match Yours? You go first", color = Color.Gray)
            Card (modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(Color.White), elevation =CardDefaults.cardElevation(4.dp)){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "How often do you drink?", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Not for me", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Sober", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Sober curious", color = Color.Gray)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "On Special occasions", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Socially on weekends", color = Color.Gray)
                    }

                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Text(text = "Most Nights", color = Color.Gray)
                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp), color = Color.Gray)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "How often do you Smoke?", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Social smoker", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Smoker when drinking", color = Color.Gray)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Non-smoker", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Smoker", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Trying to quit", color = Color.Gray)
                    }
                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp), color = Color.Gray)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "Do you Workout?", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Everyday", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Often", color = Color.Gray)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Sometimes", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Never", color = Color.Gray)
                    }
                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp), color = Color.Gray)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "Do you have pets?", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Dog", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Cat", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Reptile", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Amphibian", color = Color.Gray)
                    }

                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Bird", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Fish", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Don't have but love", color = Color.Gray)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Other", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Turtle", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Hamster", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Rabbit", color = Color.Gray)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Pet-free", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "All the pets", color = Color.Gray)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(text = "Want a pet", color = Color.Gray)
                    }

                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Text(text = "Allergic to pets", color = Color.Gray)
                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp), color = Color.Gray)


            }
            Button(onClick = {navController.navigate(Screens.Photos.Path)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }
        }


    }
}