package com.example.loginandsignup.Screenss

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.Model.PermissionHandlerr
import com.example.loginandsignup.Model.PhotoLis

import com.example.loginandsignup.Model.Pic
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.Model.UU
import com.example.loginandsignup.R
import com.example.loginandsignup.VM.VMM
import java.io.File
import java.io.FileOutputStream

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Photos(navController: NavController,sharedPreferences: SharedPreferences,ViewModel:VMM,Permissionchecker:PermissionHandlerr,context: Context){
    val editor=sharedPreferences.edit()
    val contxt = LocalContext.current
    var perm by remember { mutableStateOf(Permissionchecker.HasExtSrcPermission(context)) }
    val launcherp = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
       onResult ={permission->
           perm=permission
           if (permission==true){
               Toast.makeText(context,"Permission Granted",Toast.LENGTH_LONG).show()
           }
           else{
               Toast.makeText(context,"Permission Denied",Toast.LENGTH_LONG).show()
           }

       } )
    var PhotoList = mutableListOf<UU>()
Column (modifier = Modifier
    .fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
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

        }
    if (!perm){
        Button(onClick = {launcherp.launch(Manifest.permission.READ_MEDIA_IMAGES)}, colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.purple_700)
        ), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Request Permission to Access Gallery", color = Color.White)
        }
    }
    else{
        LazyHorizontalGrid( contentPadding = PaddingValues(10.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalArrangement = Arrangement.Center, rows = GridCells.Fixed(3), modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()){
            items(PhotoLis){data->
                LazyPhotodisplay(data = data,context,ViewModel)
            }
    }

        }
    Button(onClick = {editor.putBoolean(Shareprefff.logined.key,true)
        editor.apply()
        navController.navigate(Screens.Profile.Path)
        ViewModel.setPi(0.1f)}, colors = ButtonDefaults.buttonColors(
        colorResource(id = R.color.Pinkish)
    ), shape = CircleShape, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Next", color = Color.White)
    }
    }

}
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun LazyPhotodisplay(data:Pic,context: Context,ViewModel: VMM){
    var added by remember { mutableStateOf(false)}
    var fileUri by remember { mutableStateOf<Uri?>(null) }
    val file=File(context.filesDir,data.name)
    var photo by remember { mutableStateOf<Uri?>(null) }
    val launcherG= rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { dataa ->
        if (dataa != null) {
            context.contentResolver.openInputStream(dataa)?.use { InputStram ->
                FileOutputStream(file).use { OutputStream ->
                    InputStram.copyTo(OutputStream)
                }

            }
            fileUri = Uri.fromFile(file)
        }
        photo = dataa
    }
    Card(border = BorderStroke(2.dp, Color.Black), colors = CardDefaults.cardColors()){
        if (photo==null){
            Image(painter = painterResource(id = data.SelectionImage), contentDescription =null, modifier = Modifier
                .clickable {
                        launcherG.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

                })
        }
        else{
            AsyncImage(model =photo, contentDescription =null)
            if (added==false){
                fileUri?.let { ViewModel.setList(it) }
                added=true
            }


        }
    }
}

