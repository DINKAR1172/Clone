package com.example.loginandsignup

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.ui.theme.LoginAndSignUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAndSignUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Navigation(activity = this)
                }
            }
        }
    }
}
@Composable
fun Navigation(navHostController: NavHostController= rememberNavController(),activity: Activity){
    val AuthviewModel:ViewModel= viewModel()
    NavHost(navController =navHostController, startDestination =Screens.firstpage.Path){
        composable(Screens.firstpage.Path){
            SignUp(navHostController)
        }
        composable(Screens.SignUpByEmail.Path){
            SignUpByEmail(AuthviewModel,navHostController)
        }
        composable(Screens.SigninByEmail.Path){
            SignInByEmail(AuthviewModel,navHostController)
        }
        composable(Screens.HomePage.Path){
            HomePage()
        }
        composable(Screens.Phonepage.Path){
            PhonePage(viewModel = AuthviewModel, activity =activity , navHostController =navHostController)
        }


    }
}

