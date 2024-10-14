package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
fun SOrientation(navController: NavController,sharedPreferences: SharedPreferences,viewModel:VMM){
    val editor=sharedPreferences.edit()
    val context = LocalContext.current
    var  SOList = mutableListOf<SO>(SO(id=1,"Straight"),
        SO(id=2,"Gay"),SO(3,"Lesbian"),
        SO(4,"Bisexual"), SO(5,"Asexual"), SO(6,"Demisexual"), SO(7,"Queer"),SO(8,"Bicurious"),
        SO(9,"Aromantic"))
    var s1 by remember{ mutableStateOf<Int?>(null) }
    var selectedAns1 by remember { mutableStateOf("") }
    var selectedAns2 by remember { mutableStateOf("") }
    var selectedAns3 by remember { mutableStateOf("") }
    var s2 by remember{ mutableStateOf<Int?>(null) }
    var s3 by remember{ mutableStateOf<Int?>(null) }
    var checkBoxx by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
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
                text = "Your Sexual orientation?",
                color = colorResource(id = R.color.black),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
            Text(text = "Select up to 3", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
            Divider(thickness = 3.dp, color = Color.Gray)
            LazyColumn(){
                items(SOList){SO->
                    Text(text =SO.Orientation, color = if (s1==SO.id||s2==SO.id||s3== SO.id){
                                                                                           Color.Black
                                                                                            }
                        else{
                            Color.Gray
                            }
                        ,modifier = Modifier.clickable { if (s1==null){
                        s1=SO.id
                            selectedAns1=SO.Orientation
                    }
                    else if (s2==null){
                        s2=SO.id
                            selectedAns2=SO.Orientation
                    }
                    else if(s3==null){
                        s3=SO.id
                            selectedAns3=SO.Orientation
                    }
                    else{
                        Toast.makeText(context,"You have already selected 3 options",Toast.LENGTH_LONG).show()
                    }
                      })

                }
            }

        }
        Column {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked =checkBoxx , onCheckedChange ={checkBoxx=it}, colors = CheckboxDefaults.colors(
                    colorResource(id =R.color.Pinkish)))
                Text(text = "Show my orientation on my profile")
            }
            Button(onClick = {
                if(selectedAns1!=""){
                    editor.putString(Shareprefff.SO1.key,selectedAns1)
                editor.apply()
                }
                if (selectedAns2!=""){
                    editor.putString(Shareprefff.SO2.key,selectedAns2)
               editor.apply()
                }
                if (selectedAns3!=""){
                    editor.putString(Shareprefff.SO3.key,selectedAns3)
                    editor.apply()
                }
                navController.navigate(Screens.Intrest.Path)
                             viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Next", color = Color.White)
            }
        }
    }
}
