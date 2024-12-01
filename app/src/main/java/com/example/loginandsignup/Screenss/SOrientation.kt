package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.Model.SO
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM

@Composable
fun SOrientation(navController: NavController,sharedPreferences: SharedPreferences,viewModel:VMM) {
    val editor = sharedPreferences.edit()
    val context = LocalContext.current
    var SOList = mutableListOf<SO>(
        SO(id = 1, "Straight"),
        SO(id = 2, "Gay"),
        SO(3, "Lesbian"),
        SO(4, "Bisexual"),
        SO(5, "Asexual"),
        SO(6, "Demisexual"),
        SO(7, "Queer"),
        SO(8, "Bicurious"),
        SO(9, "Aromantic")
    )
    var s1 by remember { mutableStateOf<Int?>(null) }
    var s2 by remember { mutableStateOf<Int?>(null) }
    var s3 by remember { mutableStateOf<Int?>(null) }
    var checkBoxx by remember { mutableStateOf(false) }
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
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                LinearProgressIndicator(
                    progress = viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                        id = R.color.Pinkish
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                Text(
                    text = " Whats Your Sexual orientation?",
                    color = colorResource(id = R.color.black),
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.screenshot_2024_11_08_120052),
                    contentDescription = null
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Select up to 3",
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )
                }
                Divider(thickness = 3.dp, color = Color.Black)
                Spacer(modifier = Modifier.height(2.dp))
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.SpaceBetween,
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(SOList) { SOO ->
                        Button(
                            onClick = {
                                if (s1 == null && s2!=SOO.id &&s3!=SOO.id) {
                                    s1 = SOO.id
                                } else if (s2 == null&& s1!=SOO.id &&s3!=SOO.id) {
                                    s2 = SOO.id
                                } else if (s3 == null&& s1!=SOO.id &&s2!=SOO.id) {
                                    s3 = SOO.id
                                } else if (s1 == SOO.id) {
                                    s1 = null
                                } else if (s2 == SOO.id) {
                                    s2 = null
                                } else if (s3 == SOO.id) {
                                    s3 = null
                                }
                            },
                            shape = RectangleShape,
                            modifier = Modifier.size(width = 130.dp, height = 50.dp),
                            border = BorderStroke(
                                2.dp,
                                Color.Black
                            ),
                            colors = if (s1 == SOO.id || s2 == SOO.id || s3 == SOO.id) {
                                ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess))
                            } else {
                                ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                            }
                        ) {
                            Text(text = SOO.Orientation, color = Color.Black)
                        }

                    }
                }
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkBoxx,
                            onCheckedChange = { checkBoxx = it },
                            colors = CheckboxDefaults.colors(
                                colorResource(id = R.color.Orangess)
                            )
                        )
                        Text(text = "Show my orientation on my profile")
                    }
                    Button(
                        onClick = {
                            if (s1 !=null) {
                                editor.putString(Shareprefff.SO1.key,SOList[s1!! -1].Orientation)
                                editor.apply()
                            }
                            if (s2 != null) {
                                editor.putString(Shareprefff.SO2.key,SOList[s2!! -1].Orientation)
                                editor.apply()
                            }
                            if (s3 !=null) {
                                editor.putString(Shareprefff.SO3.key,SOList[s3!! -1].Orientation)
                                editor.apply()
                            }
                            navController.navigate(Screens.Intrest.Path)
                            viewModel.setPi(0.1f)
                        },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Orangess)),
                        shape = CircleShape,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Next", color = Color.White)
                    }
                }
            }
        }
    }
}