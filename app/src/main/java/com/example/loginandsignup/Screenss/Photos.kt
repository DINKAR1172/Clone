package com.example.loginandsignup.Screenss

import android.content.SharedPreferences
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.loginandsignup.Model.PhotoLis

import com.example.loginandsignup.Model.Pic
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.Model.UU
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM

@Composable
fun Photos(navController: NavController,sharedPreferences: SharedPreferences,ViewModel:VMM){
    var PhotoList = mutableListOf<UU>()
Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
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
        LazyVerticalGrid(columns = GridCells.Fixed(3) ){
            items(PhotoLis){P->
                LazyDisplayP(data = P,PhotoList)
            }
        }
    }
    Button(onClick = {navController.navigate(Screens.Profile.Path)
        ViewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(
        colorResource(id = R.color.Pinkish)
    ), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Next", color = Color.White)
    }

}

}
  @Composable
 fun LazyDisplayP(data:Pic,list: MutableList<UU>){
     var uriss by remember { mutableStateOf<Uri?>(null)}
      Column {
         val launcher = rememberLauncherForActivityResult(contract =
         ActivityResultContracts.PickVisualMedia(), onResult ={URI->
             uriss=URI } )
         if (uriss==null){
             Image(painter = painterResource(id =data.SelectionImage), contentDescription =null, modifier = Modifier.clickable {
                 launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                 )
                 list.add(UU(data.id,uriss))
             })
         }
         else{
             AsyncImage(model =uriss, contentDescription =null, modifier = Modifier.size(100.dp))
         }
     }

  }