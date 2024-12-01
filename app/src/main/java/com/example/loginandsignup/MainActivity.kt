package com.example.loginandsignup

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandsignup.Constant.Shareprefff
import com.example.loginandsignup.GooglePresentation.Sign_in.GoogleSignin
import com.example.loginandsignup.Model.PermissionHandlerr
import com.example.loginandsignup.Model.Screens
import com.example.loginandsignup.Screenss.DOB
import com.example.loginandsignup.Screenss.DataCollection
import com.example.loginandsignup.Screenss.Distance
import com.example.loginandsignup.Screenss.Email
import com.example.loginandsignup.Screenss.FirstPage
import com.example.loginandsignup.Screenss.Habits
import com.example.loginandsignup.Screenss.Mobile
import com.example.loginandsignup.Screenss.Name
import com.example.loginandsignup.Screenss.Photos
import com.example.loginandsignup.Screenss.SOrientation
import com.example.loginandsignup.Screenss.School
import com.example.loginandsignup.Screenss.Sex
import com.example.loginandsignup.Screenss.intrrest
import com.example.loginandsignup.Screenss.look
import com.example.loginandsignup.VM.VMM
import com.example.loginandsignup.ui.theme.LoginAndSignUpTheme
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope=lifecycleScope
            val launcher= rememberLauncherForActivityResult(contract =ActivityResultContracts.StartIntentSenderForResult(), onResult ={res->
                if (res.resultCode== RESULT_OK){

                }

            } )
            val GoogleClient by lazy {
                GoogleSignin(context = applicationContext, oneTapClient =Identity.getSignInClient(applicationContext))
            }
            val contextt = LocalContext.current
            val applicationcontext=applicationContext
            val sharepref=getSharedPreferences("UserData", Context.MODE_PRIVATE)
            LoginAndSignUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                   Navigation(
                       activity =this,
                       sharepref =sharepref,
                       context =contextt,
                       appContext =applicationContext,
                       googleAuth =GoogleClient,
                       scope = scope
                   )
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navHostController: NavHostController= rememberNavController(),activity: Activity,sharepref:SharedPreferences,context: Context,appContext:Context,googleAuth:GoogleSignin,scope:LifecycleCoroutineScope){
    var AlreadyLogined by remember { mutableStateOf(sharepref.getBoolean(Shareprefff.logined.key,false)) }
    val PermissionCheck=PermissionHandlerr(context)
    val AuthviewModel:ViewModel= viewModel()
    val VMM:VMM= viewModel()
    val GoogleSignin by lazy {
        GoogleSignin(context,Identity.getSignInClient(context))
    }
    var GoogleAuthSignin by remember { mutableStateOf(sharepref.getBoolean(Shareprefff.GoogleSignIn.key,false)) }
    NavHost(navController =navHostController, startDestination =if (GoogleAuthSignin){
        Screens.user.Path
    }else{Screens.firstpage.Path}){

        composable(Screens.firstpage.Path){
            SignUp(navHostController
            ,AuthviewModel, GOOogleAuth = googleAuth,scope,sharepref)
        }
        composable(Screens.SignUpByEmail.Path){
            SignUpByEmail(AuthviewModel,navHostController)
        }
        composable(Screens.SigninByEmail.Path){
            SignInByEmail(AuthviewModel,navHostController,sharepref)
        }
        composable(Screens.Email.Path){
            Email(navController = navHostController, sharedPreferences =sharepref)
        }
        composable(Screens.HomePage.Path){
            FirstPage(navHostController)
        }
        composable(Screens.Mobile.Path
        ){
            Mobile(navController = navHostController, sharedPreferences =sharepref )
        }
        composable(Screens.Phonepage.Path){
            PhonePage(viewModel = AuthviewModel, activity =activity , navHostController =navHostController,sharepref)
        }
        composable(Screens.Profile.Path){
            Profile(navHostController,VMM)
        }
        composable(Screens.user.Path){
            User(VMM,sharepref,navHostController,GoogleSignin,AuthviewModel, lifecycleCoroutineScope =scope)
        }
        composable(Screens.Name.Path){
            Name(sharepref,navHostController,VMM)
        }
        composable((Screens.dob.Path)){
            DOB(sharepref,navHostController,VMM)
        }
        composable(Screens.Sex.Path){
            Sex(navHostController,sharepref,VMM)
        }
        composable(Screens.SO.Path){
            SOrientation(navHostController,sharepref,VMM)
        }
        composable(Screens.Intrest.Path){
            intrrest(navHostController,sharepref,VMM)
        }
        composable(Screens.look.Path){
            look(navHostController,sharepref,VMM)
        }
        composable(Screens.distance.Path){
            Distance(navHostController,sharepref,VMM)
        }
        composable(Screens.School.Path){
            School(navHostController,sharepref,VMM)
        }
        composable(Screens.habit.Path){
            Habits(navHostController,sharepref,VMM,context)
        }
        composable(Screens.Photos.Path){
            Photos(navHostController,sharepref,VMM,PermissionCheck,context)
        }

    }
}

