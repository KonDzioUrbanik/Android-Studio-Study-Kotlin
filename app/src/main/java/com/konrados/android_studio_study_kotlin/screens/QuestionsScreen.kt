package com.konrados.android_studio_study_kotlin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun QuestionsScreenView(){
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Questions Screen in progress...")
            }

        }
    }

@Preview
@Composable
fun QuestionsScreenViewPreview(){
    QuestionsScreenView()
}

