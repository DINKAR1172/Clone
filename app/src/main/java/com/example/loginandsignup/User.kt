package com.example.loginandsignup

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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat.startActivityForResult
import coil.compose.AsyncImage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun User(sharedPreferences: SharedPreferences){
    var SelectImages by remember { mutableStateOf< List<Uri>>(emptyList())}
    val Name by remember { mutableStateOf(sharedPreferences.getString("Name","")) }
    val Age by remember { mutableStateOf(sharedPreferences.getInt("Age",0)) }
    val Email by remember { mutableStateOf(sharedPreferences.getString("Email","")) }
    val Gender by remember { mutableStateOf(sharedPreferences.getString("Gender","")) }
    val Mobile by remember { mutableStateOf(sharedPreferences.getLong("MobileNumber",0L)) }
    val Dob by remember { mutableStateOf(sharedPreferences.getLong("Dob",0L)) }
    var SelectMultipleImage= rememberLauncherForActivityResult(contract =ActivityResultContracts.PickMultipleVisualMedia(), onResult ={uris->SelectImages=uris} )
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Name : $Name")
        Text(text = "Age :$Age")
        Text(text = "Phone Number : $Mobile")
        Text(text = "Email : $Email")
        Text(text = "Gender :$Gender")
        Button(onClick = {SelectMultipleImage.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )}) {
            Text(text = "Show")
        }
      LazyColumn(){
          items(SelectImages){uri->
              AsyncImage(model = uri, contentDescription =null)

          }
      }


    }

}