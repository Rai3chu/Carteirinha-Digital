package com.senai.carteirinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.senai.carteirinhadigital.R
import com.senai.carteirinhadigital.app.navegation.Routes
import com.senai.carteirinhadigital.core.desingsystem.theme.Montserrat

@Composable
fun LoginScreen(
    navController: NavHostController = NavHostController(
        LocalContext.current
    ),
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize()) {
        // Imagem de Fundo
        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    // Título "Login"
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontFamily = Montserrat,
                        fontSize = 44.sp
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // Campo de Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { novoTexto ->
                            email = novoTexto
                            errorMessage = ""
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Email") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    // Campo de Senha
                    OutlinedTextField(
                        value = senha,
                        onValueChange = { novoTexto ->
                            senha = novoTexto
                            errorMessage = ""
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Senha") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    // Mensagem de Erro (se houver)
                    if (errorMessage.isNotEmpty()) {
                        Text(
                            text = errorMessage,
                            color = Color.Yellow,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Botão
                    Button(
                        onClick = {
                            val emailTrimmed = email.trim()
                            val senhaTrimmed = senha.trim()

                            when {
                                emailTrimmed == "aluno@senai.br" && senhaTrimmed == "123456" -> {
                                    navController.navigate(Routes.Home.route) {
                                        popUpTo(Routes.Login.route) { inclusive = true }
                                    }
                                }
                                emailTrimmed == "professor@senai.br" && senhaTrimmed == "123456" -> {
                                    navController.navigate(Routes.HomeProf.route) {
                                        popUpTo(Routes.Login.route) { inclusive = true }
                                    }
                                }
                                else -> {
                                    errorMessage = "E-mail ou senha inválidos!"
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF8B0000)
                        )
                    ) {
                        Text(
                            text = "Entrar",
                            color = Color(0xFF8B0000),
                            fontFamily = Montserrat,
                            fontSize = 15.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.senai),
                    contentDescription = "Logo SENAI",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 60.dp)
                        .width(200.dp)
                )
            }
        }
    }
}