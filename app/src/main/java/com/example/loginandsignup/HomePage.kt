package com.example.loginandsignup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Welcome to Home Page")
    }
}