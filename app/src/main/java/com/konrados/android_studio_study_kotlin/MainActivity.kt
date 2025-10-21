package com.konrados.android_studio_study_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.konrados.android_studio_study_kotlin.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController() // tworzymy kontroler nawigacji
            AppNavHost(nav = nav)             // podpinamy nasz NavHost z trasami
        }
    }
}
