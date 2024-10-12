package com.example.loginandsignup.Screenss
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.R

@Composable
fun FirstPage(navController: NavController){
Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Column {

        Text(text = "Welcome to LinkUp", color = colorResource(id = R.color.Pinkish), fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
        Text(text = "Please follow these House Rules", color = Color.Gray)
    }
    Column {
        Text(text = "1: Be Yourself", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        Text(text = "Make sure your photos,age,and bio are true to who you are.", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(4.dp))
    Column {
        Text(text = "2: Stay safe", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        Text(text = "Don't be too quick to give out personal information.", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(4.dp))
    Column {
        Text(text = "3: Play it cool", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        Text(text = "Respect others and treat them as you would like to be treated.", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(4.dp))
    Column {
        Text(text = "4: Be Proactive", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        Text(text = "Always report bad behaviour.", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(5.dp))
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(3.dp)){
        Button(onClick = {navController.navigate(Screens.Name.Path)}, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Pinkish)), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
           Text(text = "I agree", color = Color.White)            
        }
    }
}
}