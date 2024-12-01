package com.example.loginandsignup.Screenss

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
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
fun Habits(navController: NavController,sharedPreferences: SharedPreferences,ViewModel: VMM,context: Context){
    val editor=sharedPreferences.edit()
    var HabitList= arrayListOf<String>()
    val gson=Gson()
    var s1 by remember { mutableStateOf("") }
    var s2 by remember { mutableStateOf("") }
    var s3 by remember { mutableStateOf("") }
    var s4 by remember { mutableStateOf("") }
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                androidx.compose.material.IconButton(onClick = {
                    navController.navigateUp()
                    ViewModel.setPi(-0.1f)
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
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .height(730.dp)) {
                LinearProgressIndicator(
                    progress =ViewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                        id = R.color.Pinkish
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Column {
                        Text(text = "Whats", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "Your", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "lifestyle habits?", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                    }
                    Image(painter = painterResource(id = R.drawable.wellness_healthy_health_lifestyle_well_being_health_conscious_management_svgrepo_com), contentDescription =null)
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "Do their habits match Yours? You go first", color = Color.Gray)
                }

                Card (modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),colors = CardDefaults.cardColors(Color.White), elevation =CardDefaults.cardElevation(4.dp)){
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "How often do you drink?", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s1="Not for me"}, colors =if (s1=="Not for me"){
                                                                                         ButtonDefaults.buttonColors(
                                                                                             colorResource(
                                                                                                 id = R.color.Orangess
                                                                                             ))
                                                                                         }
                            else{
                                ButtonDefaults.buttonColors(Color.White)
                                }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Not for me", color = Color.Black)
                        }
                        Button(onClick = {s1="Sober"}, colors =if (s1=="Sober"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Sober", color = Color.Black)
                        }
                        Button(onClick = {s1="Sober curious"}, colors =if (s1=="Sober curious"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Sober curious", color = Color.Black)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s1="On Special occasions"}, colors =if (s1=="On Special occasions"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "On Special occasions", color = Color.Black)
                        }
                        Button(onClick = {s1="Socially on weekends"}, colors =if (s1=="Socially on weekends"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Socially on weekends", color = Color.Black)
                        }
                    }
                    Button(onClick = {s1="Most Nights"}, colors =if (s1=="Most Nights"){
                        ButtonDefaults.buttonColors(
                            colorResource(
                                id = R.color.Orangess
                            ))
                    }
                    else{
                        ButtonDefaults.buttonColors(Color.White)
                    }, border = BorderStroke(2.dp,
                        Color.Black
                    )) {
                        Text(text = "Most Nights", color = Color.Black)
                    }

                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp), color = Color.Gray)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "How often do you Smoke?", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s2="Social smoker"}, colors =if (s2=="Social smoker"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Social smoker", color = Color.Black)
                        }
                        Button(onClick = {s2="Smoker when drinking"}, colors =if (s2=="Smoker when drinking"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Smoker when drinking", color = Color.Black)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s2="Non-smoker"}, colors =if (s2=="Non-smoker"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Non-smoker", color = Color.Black)
                        }
                        Button(onClick = {s2="Smoker"}, colors =if (s2=="Smoker"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Smoker", color = Color.Black)
                        }
                        Button(onClick = {s2="Trying to quit"}, colors =if (s2=="Trying to quit"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Trying to quit", color = Color.Black)
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp), color = Color.Gray)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "Do you Workout?", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s3="Everyday"}, colors =if (s3=="Everyday"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Everyday", color = Color.Black)
                        }
                        Button(onClick = {s3="Often"}, colors =if (s3=="Often"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Often", color = Color.Black)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s3="Sometimes"}, colors =if (s3=="Sometimes"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Sometimes", color = Color.Black)
                        }
                        Button(onClick = {s3="Never"}, colors =if (s3=="Never"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Never", color = Color.Black)
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp), color = Color.Gray)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "Do you have pets?", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s4="Dog"}, colors =if (s4=="Dog"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Dog", color = Color.Black)
                        }
                        Button(onClick = {s4="Cat"}, colors =if (s4=="Cat"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Cat", color = Color.Black)
                        }
                        Button(onClick = {s4="Reptile"}, colors =if (s4=="Reptile"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Reptile", color = Color.Black)
                        }
                        Button(onClick = {s4="Amphibian"}, colors =if (s4=="Amphibian"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Amphibian", color = Color.Black)
                        }

                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s4="Bird"}, colors =if (s4=="Bird"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Bird", color = Color.Black)
                        }
                        Button(onClick = {s4="Fish"}, colors =if (s4=="Fish"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Fish", color = Color.Black)
                        }
                        Button(onClick = {s4="Don't have but love"}, colors =if (s4=="Don't have but love"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Don't have but love", color = Color.Black)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s4="Other"}, colors =if (s4=="Other"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Other", color = Color.Black)
                        }
                        Button(onClick = {s4="Turtle"}, colors =if (s4=="Turtle"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Turtle", color = Color.Black)
                        }
                        Button(onClick = {s4="Hamster"}, colors =if (s4=="Hamster"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Hamster", color = Color.Black)
                        }
                        Button(onClick = {s4="Rabbit"}, colors =if (s4=="Rabbit"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Rabbit", color = Color.Black)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = {s4="Pet-free"}, colors =if (s4=="Pet-free"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Pet-free", color = Color.Black)
                        }
                        Button(onClick = {s4="All the pets"}, colors =if (s4=="All the pets"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "All the pets", color = Color.Black)
                        }
                        Button(onClick = {s4="Want a pet"}, colors =if (s4=="Want a pet"){
                            ButtonDefaults.buttonColors(
                                colorResource(
                                    id = R.color.Orangess
                                ))
                        }
                        else{
                            ButtonDefaults.buttonColors(Color.White)
                        }, border = BorderStroke(2.dp,
                            Color.Black
                        )) {
                            Text(text = "Want a pet", color = Color.Black)
                        }

                    }
                    Button(onClick = {s4="Allergic to pets"}, colors =if (s4=="Allergic to pets"){
                        ButtonDefaults.buttonColors(
                            colorResource(
                                id = R.color.Orangess
                            ))
                    }
                    else{
                        ButtonDefaults.buttonColors(Color.White)
                    }, border = BorderStroke(2.dp,
                        Color.Black
                    )) {
                        Text(text = "Allergic to pets", color = Color.Black)
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp), color = Color.Gray)


                }

            }
            Button(onClick = {if (s1!=""&&s2!=""&&s3!=""&&s4!=""){
                editor.putString(Shareprefff.habit1.key,s1)
                editor.putString(Shareprefff.habit2.key,s2)
                editor.putString(Shareprefff.habit3.key,s3)
                editor.putString(Shareprefff.habit4.key,s4)
                editor.apply()
                navController.navigate(Screens.Photos.Path)
                ViewModel.setPi(0.1f)
            }
                else{
                  Toast.makeText(context,"Please Answer all question",Toast.LENGTH_LONG).show()
                }
                }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }

        }

    }

}