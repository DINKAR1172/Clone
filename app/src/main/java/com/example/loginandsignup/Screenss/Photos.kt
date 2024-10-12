package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R

@Composable
fun Photos(navController: NavController,sharedPreferences: SharedPreferences){
Column {
    Button(onClick = {navController.navigate(Screens.Profile.Path)}, colors = ButtonDefaults.buttonColors(
        colorResource(id = R.color.Pinkish)
    ), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Next", color = Color.White)
    }
}
}