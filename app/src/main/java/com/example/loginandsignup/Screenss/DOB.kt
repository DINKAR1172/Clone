package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
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
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Formatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DOB(sharedPreferences: SharedPreferences,navController: NavController,viewModel: VMM){
    val Formatter= DateTimeFormatter.ofPattern("dd/MM/YYYY")
    var Day by remember { mutableStateOf("") }
    val editor =sharedPreferences.edit()
    var dd by remember { mutableStateOf(false) }
    var din by remember { mutableStateOf("") }
    var DateState= rememberDatePickerState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
        Column {
            LinearProgressIndicator(progress =viewModel.pi.value, trackColor = Color.Gray, color = colorResource(
                id = R.color.Pinkish
            ), modifier = Modifier
                .fillMaxWidth()
                .height(8.dp))
            IconButton(onClick = {navController.navigateUp()
                viewModel.setPi(-0.1f)}) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription =null)
            }
            Text(text = "Your b-day?", color = colorResource(id = R.color.black), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
            Button(onClick = {dd=true}) {
                Text(text ="DatePickDialog")
            }
            if(DateState.selectedDateMillis!=null){
                Text(text =Day)
            }
            else{
                Text(text = "Select a Date")
            }

            if (dd==true){
                DatePickerDialog(onDismissRequest = {dd=false}, confirmButton = { Button(onClick = {
                    if(DateState.selectedDateMillis!=null){
                        var din = mutableStateOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(
                            DateState.selectedDateMillis!!
                        ), ZoneId.systemDefault()))
                        Day=din.value.format(Formatter)

                    }

                    dd=false}, colors = ButtonDefaults.buttonColors(
                    Color.Green
                )) {
                    Text(text = "Confirm", color = Color.White)
                }}) {
                    DatePicker(state =DateState)
                }
            }
        }

        Button(onClick = {editor.putString(Shareprefff.DateofBirth.key,Day)
            editor.apply()
            navController.navigate(Screens.Sex.Path)
                         viewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Next", color = Color.White)
        }
    }
}


