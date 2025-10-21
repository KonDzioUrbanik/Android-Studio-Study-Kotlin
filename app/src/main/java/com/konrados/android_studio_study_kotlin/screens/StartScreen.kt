package com.konrados.android_studio_study_kotlin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun StartScreenView(
        onLoginSuccess: (String) -> Unit = {},
    ) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Blue.copy(0.3f)),
                verticalArrangement = Arrangement.spacedBy(
                    10.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Logowanie", color = Color.Black, fontSize = 25.sp)
                OutlinedTextField(
                    singleLine = true,
                    value = login,
                    onValueChange = { login = it},
                    label = { Text(text = "Login") },
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(), // 🔹 tu zamienia znaki na kropki
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Button(
                    onClick = {
                        val name = login.trim()
                        if (name.isNotEmpty()){
                            onLoginSuccess(name)
                        }
                    },
                ) {
                    Text("Zaloguj")
                }
            }
        }

    }

@Preview(showBackground = true)
@Composable
fun StartScreenViewPreview() {
    StartScreenView()
}


