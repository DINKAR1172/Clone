package com.example.loginandsignup

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.VM.VMM

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun User(viewModel:VMM,sharedPreferences: SharedPreferences,navController: NavController){
    var name by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Name.key,null))}
    var email by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Email.key,null))}
    var mobile by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Phone.key,null))}
    var Gender by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Gender.key,null))}
    var Dob by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.DateofBirth.key,null))}
    var s01 by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.SO1.key,null))}
    var s02 by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.SO2.key,null))}
    var s03 by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.SO3.key,null))}
    var Intrest by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.Intrest.key,null))}
    var Habits by remember { mutableStateOf(sharedPreferences.getString(Shareprefff.habit.key,null))}
    var Distance by remember { mutableStateOf(sharedPreferences.getFloat(Shareprefff.distance.key,0.0f))}
    var Uri by remember { mutableStateOf<Uri?>(null) }
    val launcherP= rememberLauncherForActivityResult(contract =ActivityResultContracts.PickVisualMedia(), onResult ={aa->
        Uri=aa })
    Column {
        Row(modifier = Modifier.fillMaxWidth(.63f), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
               IconButton(onClick = {navController.navigateUp()}) {
                   Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null)
                   }
            Text(text = "Profile", fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = colorResource(id = R.color.Pinkish))
               }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            if (Uri==null){
                Image(imageVector =Icons.Default.AccountCircle, contentDescription =null, modifier = Modifier
                    .background(color = Color.White, shape = CircleShape)
                    .size(150.dp)
                    .clickable { launcherP.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) })
            }
            else{
                AsyncImage(model = Uri, contentDescription =null, modifier = Modifier
                    .background(color = Color.White, shape = CircleShape)
                    .size(150.dp))
            }

        }
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Name:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$name", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Email:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$email", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Mobile:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$mobile", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Gender:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$Gender", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Date of Birth:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$Dob", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
          /* Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
               Text(text = "Sexual Orientation:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
               Text(text = "$s01", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
               Text(text = "$s02", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
               Text(text = "$s03", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
           }*/
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Distance Preffered:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "${Distance}Km", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Intrest:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$Intrest", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Habits:", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.black))
                Text(text = "$Habits", fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = colorResource(id = R.color.teal_700))
            }


        }
    }

}
@Composable
fun LazyUserDisplay(data:Uri){
    Card(border = BorderStroke(2.dp, color = Color.Black)){
        AsyncImage(model =data, contentDescription =null)
    }
}