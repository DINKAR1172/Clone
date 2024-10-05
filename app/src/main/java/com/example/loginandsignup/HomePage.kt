package com.example.loginandsignup

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginandsignup.Model.Screens
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Scanner
import java.util.logging.SimpleFormatter


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(sharedpref:SharedPreferences,viewModel: ViewModel,navController: NavController){
    var num by remember { mutableStateOf("") }
    var Diaglog by remember { mutableStateOf(false) }
    var DateState = rememberDatePickerState(yearRange = 2000..2024)
    var SEditor=sharedpref.edit()
    var Email by remember { mutableStateOf(sharedpref.getString("Email",null)) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top){
        Text(text = " User Information", fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
        OutlinedTextField(value =viewModel.name.value, onValueChange ={viewModel.SetName(it)
                                                                      SEditor.putString("Name",viewModel.name.value)
                                                                      SEditor.apply()}, singleLine = true, label = { Text(
            text = "Name"
        )})
        if(viewModel.Phonenumber.value==null){
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value =num, onValueChange ={num=it
                viewModel.setPhoneNumber(num)
                viewModel.Phonenumber.value?.let { it1 -> SEditor.putLong("MobileNumber", it1) }
                SEditor.apply()}, singleLine = true, label = { Text(text = "Phone Number")})
        }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value =viewModel.Email.value, onValueChange ={viewModel.setEmail(it)
                SEditor.putString("Email",viewModel.Email.value)
                SEditor.apply()}, singleLine = true, label = { Text(text = "Email")})

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value =viewModel.Gender.value, onValueChange ={viewModel.SetGender(it)
        SEditor.putString("Gender",viewModel.Gender.value)
        SEditor.apply()}, singleLine = true, label = { Text(text = "Gender")})
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
           if (viewModel.DateofBirth.value==null){
              Text(text = "Select DoB")        
           }
            else{
               Text(text = FormatDateTime(viewModel.DateofBirth.value!!))
            }
           Spacer(modifier = Modifier.width(3.dp))
            
            Button(onClick = {Diaglog=true}) {
                Text(text = "Change DoB")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = {viewModel.DateofBirth.value?.let { SEditor.putLong("Dob", it) }
            SEditor.apply()
            navController.navigate(Screens.Profile.Path)
        }) {
        Text(text = "Continue")
        }
        if(Diaglog==true){
            DatePickerDialog(onDismissRequest = {Diaglog=false}, confirmButton = { Button(onClick = {if (DateState.selectedDateMillis!=null){
                viewModel.SetDoB(DateState.selectedDateMillis)
                Diaglog=false
            } }) {
                Text(text = "Confirm")
            }}) {
                DatePicker(state =DateState)

            }
        }



    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun FormatDateTime(TimeStamp:Long):String{
    val formatter=LocalDateTime.ofInstant(Instant.ofEpochMilli(TimeStamp), ZoneId.systemDefault())
val format=DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return formatter.format(format)
}