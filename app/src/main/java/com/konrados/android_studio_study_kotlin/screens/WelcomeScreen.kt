package com.konrados.android_studio_study_kotlin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrados.android_studio_study_kotlin.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(username: String) {
    Scaffold {
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(

                modifier = Modifier
                    .width(220.dp)
                    .height(140.dp)
                    .padding(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                ),

            ) {
                Text(text = "Witaj, $username!", modifier = Modifier
                    .padding(0.dp,10.dp)
                    .align(Alignment.CenterHorizontally),
                )

            }

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp,120.dp,40.dp,0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(){
                Button(
                    onClick = { /*TODO*/ },
                ) {

                }
            }
            Box(){
                Button(
                    onClick = { /*TODO*/ },
                ) {

                }
            }
            Box(){
                Button(
                    onClick = { /*TODO*/ },
                ) {

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(username = "Username")
}

