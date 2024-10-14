package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM

@Composable
fun Photos(navController: NavController,sharedPreferences: SharedPreferences,ViewModel:VMM){
Column {
    LinearProgressIndicator(
        progress =ViewModel.pi.value, trackColor = Color.Gray, color = colorResource(
            id = R.color.Pinkish
        ), modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
    )
    IconButton(onClick = {navController.navigateUp()
        ViewModel.setPi(-0.1f)}) {
        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
    }
    Button(onClick = {navController.navigate(Screens.Profile.Path)
                     ViewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(
        colorResource(id = R.color.Pinkish)
    ), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Next", color = Color.White)
    }
}
}