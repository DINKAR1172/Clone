package com.example.loginandsignup

import android.content.SharedPreferences
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun User(sharedPreferences: SharedPreferences){
    val Name by remember { mutableStateOf(sharedPreferences.getString("Name","")) }
    val Email by remember { mutableStateOf(sharedPreferences.getString("Email","")) }
    val Gender by remember { mutableStateOf(sharedPreferences.getString("Gender","")) }
    val Mobile by remember { mutableStateOf(sharedPreferences.getLong("MobileNumber",0L)) }
    val Dob by remember { mutableStateOf(sharedPreferences.getLong("Dob",0L)) }
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Name : $Name")
        Text(text = "Phone Number : $Mobile")
        Text(text = "Email : $Email")
        Text(text = "Gender :$Gender")
        Text(text = "Date of Birth :${FormatDateTime(Dob)}")


    }

}