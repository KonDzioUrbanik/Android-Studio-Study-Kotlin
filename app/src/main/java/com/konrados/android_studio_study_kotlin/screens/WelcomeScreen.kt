package com.konrados.android_studio_study_kotlin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrados.android_studio_study_kotlin.R



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    username: String,
    onOpenQuestions: (String) -> Unit = {}
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row { //Pierwszy wiersz
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
            ) {
                Text(
                    text = "Witaj, $username!",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                )
            }
            }
            Row( //Drugi wiersz
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(top = 30.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        onClick = { onOpenQuestions("adhd") },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.adhd),
                            contentDescription = "ADHD",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(48.dp)
                        )

                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        onClick = { },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.depression),
                            contentDescription = "depression",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(48.dp)
                        )

                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        onClick = { },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.anxiety),
                            contentDescription = "anxiety",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(48.dp)
                        )

                    }


            }
            Row ( //Trzeci wiersz
                modifier = Modifier
                    .fillMaxSize()
                    .padding(100.dp),
                horizontalArrangement = Arrangement.Center

            ){  Text("In progress... Soon...")}
        }


    }

}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(username = "Username")
}

