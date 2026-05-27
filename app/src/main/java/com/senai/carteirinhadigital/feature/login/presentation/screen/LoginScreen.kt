package com.senai.carteirinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()

    ) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, )
    ) {

        Text(
            text = "Login",
            color = Color.Yellow
        )

        TextField(
            value = "",
            onValueChange = {},

            label = {
                Text(text = "Email")
            }
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Senha")
            }
        )

        Button(
            onClick = {}
        ) {
            Text(text = "Entrar")
        }
    }
    }
}

