package com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.presentation.components.UnidadeCurricularCard
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel

// Definição das cores personalizadas do design original
val Vinho = Color(0xFF8B0000)
val Branco = Color.White

@Composable
fun UnidadeCurricularScreen(
    viewModel: UnidadeCurricularViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val errorMessage = uiState.errorMessage
    val headerHeight = 90.dp

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Imagem de Fundo constante para todos os estados
        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = "Fundo da Tela",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Controlo de Estados da UI com a nova estrutura 'when'
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Branco)
                }
            }

            errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = errorMessage,
                        color = Color.Yellow
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = { viewModel.carregar() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Branco,
                            contentColor = Vinho
                        )
                    ) {
                        Text("Tentar novamente")
                    }
                }
            }

            uiState.unidades.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Nenhuma unidade curricular encontrada.",
                        color = Branco
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        top = headerHeight + 16.dp,
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = uiState.unidades as List<UnidadeCurricular>, // Força a lista a ser reconhecida
                        key = { it.id }
                    ) { unidadeCurricular ->
                        UnidadeCurricularCard(
                            unidadeCurricular = unidadeCurricular
                        )
                    }
                }
            }
        }

        // Botão Fixo de Voltar sobreposto ao conteúdo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Button(
                onClick = onBackClick,
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "Voltar",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}