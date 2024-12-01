package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
     var selectedAns by remember { mutableStateOf<Int?>(null) }
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
            Column {
                LinearProgressIndicator(
                    progress =viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                        id = R.color.Pinkish
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Column {
                        Text(text = "Whats", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "your ", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        Text(text = "future goal?", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                    }
                    Image(painter = painterResource(id = R.drawable.family_planning_commission_svgrepo_com), contentDescription =null)
                }
                LazyHorizontalGrid(modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp),rows =GridCells.Fixed(2),horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.SpaceBetween,
                    contentPadding = PaddingValues(10.dp)
                ){
                    items(Looklist){data->
                        Button(
                            onClick = {
                                      selectedAns=data.id
                            },
                            shape = RectangleShape,
                            modifier = Modifier.size(width = 130.dp, height = 50.dp),
                            border = BorderStroke(
                                2.dp,
                                Color.Black
                            ),
                            colors = if (selectedAns==data.id) {
                                ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess))
                            } else {
                                ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                            }
                        ) {
                            Column {
                                Text(text = data.type, color = Color.Black)
                                Image(painter = painterResource(id = data.Image), contentDescription =null)
                            }

                        }
                    }
                }
            }
            Button(onClick = {if (selectedAns!=null){
                editor.putString(Shareprefff.look.key, Looklist[selectedAns!!].type)
                editor.apply()
            }
                navController.navigate(Screens.distance.Path)
                viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }
        }
    }

}