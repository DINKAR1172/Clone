package com.example.loginandsignup.Model

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class PermissionHandlerr(val context: Context){
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun HasExtSrcPermission(context: Context):Boolean{
        return ContextCompat.checkSelfPermission(context,Manifest.permission.READ_MEDIA_IMAGES) ==PackageManager.PERMISSION_GRANTED}}