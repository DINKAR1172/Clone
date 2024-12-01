package com.example.loginandsignup.Screenss

import android.net.Uri
import android.os.Build
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.loginandsignup.R
import com.example.loginandsignup.RetroLocation.IT
import com.example.loginandsignup.RetroLocation.Result
import com.example.loginandsignup.RetroLocation.RetroViewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataCollection(){
    var intresting= remember { mutableStateListOf<IT>(IT("Reading", mutableStateOf(false)),IT("Travelling",
        mutableStateOf(false)
    ),
        IT("Cooking", mutableStateOf(false)),IT("Photography", mutableStateOf(false)),IT("Fitness",
            mutableStateOf(false)
        ),IT("Gardening", mutableStateOf(false)),IT("Painting", mutableStateOf(false)),IT("Music",
            mutableStateOf(false)
        ),IT("Gamming", mutableStateOf(false)),IT("Hiking", mutableStateOf(false)),IT("Temples",
            mutableStateOf(false)
        ),IT("Clubbing", mutableStateOf(false)),IT("Parties", mutableStateOf(false)),IT("Movies",
            mutableStateOf(false)
        ),IT("+ Add New", mutableStateOf(false)))}
    val viewmodel:RetroViewModel= viewModel()
    var pincodeAlert by remember { mutableStateOf(false) }
    val locationState =viewmodel.retroresult.observeAsState()
    var pincode by remember { mutableStateOf("") }
    var dobBox by remember { mutableStateOf(false) }
    var dobstate= rememberDatePickerState()
    var name by remember { mutableStateOf("") }
    var Bio by remember { mutableStateOf("") }
    val photoListss = remember {mutableStateListOf<Uri>()}
    var Addnew by remember { mutableStateOf(false) }
    var NewIntrest by remember { mutableStateOf("") }
    var photoLauncher= rememberLauncherForActivityResult(contract =ActivityResultContracts.PickVisualMedia(), onResult ={pic->
        if (pic != null) {
            photoListss.add(pic)
        }
    })
    Scaffold(topBar = { TopAppBar(navigationIcon = {
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription =null, tint = Color.White
            )
        }
        },colors = TopAppBarDefaults.topAppBarColors(
        colorResource(id = R.color.Skin)
    ),title = { Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        Text(text = "Tell Us About Yourself", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
        })}){ it ->
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(it), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                Text(text = "Name", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value =name, onValueChange ={name=it}, modifier = Modifier.fillMaxWidth(), placeholder = { Text(
                    text = "Full Name", color = Color.Gray
                )}, singleLine = true)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Add Bio", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value =Bio, onValueChange ={Bio=it}, modifier = Modifier.fillMaxWidth(), placeholder = { Text(
                    text = "Describe Yourself in 250 Characters....", color = Color.Gray
                )}, maxLines = 3)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Add Photos", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Top){
                    Image(painter = painterResource(id = R.drawable.image), contentDescription =null,modifier= Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .clickable {
                            photoLauncher.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        })
                    if (photoListss.isNotEmpty()){
                        LazyHorizontalGrid(rows = GridCells.Fixed(1), modifier = Modifier.fillMaxWidth()){
                            items(photoListss){SelectedPics->
                                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement =Arrangement.Top){
                                    AsyncImage(model =SelectedPics, contentDescription =null, modifier = Modifier
                                        .size(80.dp)
                                        .clip(RectangleShape))
                                    IconButton(onClick = {photoListss.remove(SelectedPics)}) {
                                        Icon(imageVector = Icons.Default.Delete, contentDescription =null, tint = Color.Red)
                                    }
                                }

                            }
                        }
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
                if (dobBox){
                    DatePickerDialog(
                        onDismissRequest = {dobBox=false},
                        confirmButton = {
                            Row(modifier = Modifier
                                .fillMaxWidth(), horizontalArrangement = Arrangement.End){
                                IconButton(onClick = { dobBox = false}, colors = IconButtonDefaults.iconButtonColors(
                                    Color.Red
                                )) {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription =null)
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                IconButton(onClick = { dobBox = false}, colors = IconButtonDefaults.iconButtonColors(
                                    Color.Green
                                )) {
                                    Icon(imageVector = Icons.Default.Done, contentDescription =null)
                                }
                            }
                        }) {
                        DatePicker(state =dobstate)

                    }
                }
                Text(text = "Date of Birth", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
                Column(modifier= Modifier
                    .fillMaxWidth()
                    .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top){
                    if (dobstate.selectedDateMillis!=null){
                        Text(text = dateconverter(dobstate.selectedDateMillis!!), fontWeight = FontWeight.Bold)
                    }
                    Button(onClick = {dobBox=true}, shape = RectangleShape, modifier = Modifier.size(width=300.dp,height=50.dp)) {
                        Text(text = "Select a date")
                        Icon(imageVector = Icons.Default.DateRange, contentDescription =null)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Address", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top){
                    OutlinedTextField(value =pincode, onValueChange ={pincode=it}, placeholder = { Text(
                        text = "Enter Pincode"
                    )})
                    IconButton(onClick = {
                        if (pincode !=""){
                            viewmodel.getdata(pincode)
                            pincodeAlert=true
                        }
                    }) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription =null)
                    }
                }
                if (pincodeAlert==true){
                    Spacer(modifier = Modifier.height(5.dp))
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                        when(val result=locationState.value){
                            is Result.loading->{ CircularProgressIndicator()}
                            is Result.sucess->{
                                val locationdata by remember { mutableStateOf(result.data)}
                                locationdata.let {
                                    var statedata by remember { mutableStateOf(it.places[locationdata.places.size-1])}
                                    Text(text ="State : ${statedata.state}")
                                    Text(text = "City: ${statedata.placename}")
                                    Text(text = "longitude: ${statedata.longitude}")
                                    Text(text = "lattitude: ${statedata.latitude}")
                                }

                            }
                            is Result.exception->{ Text(text = "Error Occoured")}
                            else -> {}
                        }
                    }

                }
                Text(text = "Select Intrest/Hobbies", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 25.sp)
            if (Addnew){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    OutlinedTextField(value =NewIntrest, onValueChange ={NewIntrest=it}, placeholder = { Text(
                        text = "Add Interest"
                    )})
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(onClick = {intresting.add(intresting.size-1,
                        IT(name = NewIntrest, isSelected= mutableStateOf(true))
                    )
                       NewIntrest=""
                        Addnew=false}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription =null)
                    }
                }
            }
            LazyVerticalGrid(modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),columns = GridCells.Fixed(3), horizontalArrangement = Arrangement.SpaceAround, verticalArrangement = Arrangement.SpaceBetween, contentPadding = PaddingValues(2.dp)){
                    items(intresting){
                        Button(border = BorderStroke(2.dp, color = Color.Black),colors = if (it.isSelected.value){
                                                          ButtonDefaults.buttonColors(colorResource(
                                                              id = R.color.Orangess
                                                          ))
                                                          }else{
                                                               ButtonDefaults.buttonColors(Color.White)
                                                               },onClick = {if (it.name=="+ Add New"){
                            Addnew=true
                        }
                        else if (it.isSelected.value==true){
                            it.isSelected.value=false
                        }
                            else if (it.isSelected.value==false){
                                it.isSelected.value=true
                            }
                                         }
                        ) {
                            if (it.name =="Photography"){
                                Text(text = it.name, fontSize = 13.sp, color = Color.Black)
                            }
                            else{
                                Text(text = it.name, color = Color.Black)
                            }

                        }
                    }
                }


                }

        }
    }

@RequiresApi(Build.VERSION_CODES.O)
fun dateconverter(timestamp:Long):String{
val date=LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
val formatter=DateTimeFormatter.ofPattern("dd/MM/YYYY")
    return date.format(formatter)
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun DisplayScreen(){
    DataCollection()
}