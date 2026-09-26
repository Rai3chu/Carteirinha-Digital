package com.senaisp.carteirinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senai.carteirinhadigital.core.desingsystem.theme.Montserrat
import com.senai.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.feature.login.presentation.LoginEvent
import com.senai.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.senaisp.carteirinhadigital.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onProfessorClick: () -> Unit,
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        // Imagem de Fundo
        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Conteúdo Principal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // Título "Login"
            Text(
                text = "Login",
                color = Color.White,
                fontFamily = Montserrat,
                fontSize = 44.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Campo E-mail
            OutlinedTextField(
                value = uiState.usuario,
                onValueChange = { value ->
                    viewModel.onEvent(LoginEvent.OnUsuarioChange(value))
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Senha
            OutlinedTextField(
                value = uiState.senha,
                onValueChange = { value ->
                    viewModel.onEvent(LoginEvent.OnSenhaChange(value))
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Senha") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            // Mensagem de Erro
            uiState.erroMessage?.let { error ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = error,
                    color = Color.Yellow,
                    fontSize = 14.sp,
                    fontFamily = Montserrat
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botão Entrar
            Button(
                onClick = { viewModel.onEvent(LoginEvent.OnEntrarClick) },
                enabled = !uiState.isLoading,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF8B0000)
                )
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color(0xFF8B0000)
                    )
                } else {
                    Text(
                        text = "Entrar",
                        color = Color(0xFF8B0000),
                        fontFamily = Montserrat,
                        fontSize = 15.sp
                    )
                }
            }

            // Botão Entrar como Professor
            TextButton(
                onClick = onProfessorClick,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Entrar como professor",
                    color = Color.White,
                    fontFamily = Montserrat,
                    fontSize = 14.sp
                )
            }
        }

        // Logo SENAI no fundo
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