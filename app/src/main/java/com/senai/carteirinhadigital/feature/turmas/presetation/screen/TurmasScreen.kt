package com.senai.carteirinhadigital.feature.turmas.presetation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.data.dataSource
import com.senai.carteirinhadigital.feature.turmas.presetation.components.TurmasCard
import com.senai.carteirinhadigital.feature.turmas.domain.model.Turma
import com.senai.carteirinhadigital.feature.turmas.presetation.TurmaViewModel
import com.senaisp.carteirinhadigital.R
import androidx.compose.runtime.getValue
import com.senai.carteirinhadigital.feature.turmas.presetation.components.TurmasCard


@Composable
fun TurmasScreen(
    viewModel: TurmaViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val headerHeight = 90.dp

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.blackbg),
            contentDescription = "Fundo da Tela",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            uiState.errorMessage != null -> {
                Text(
                    text = uiState.errorMessage ?: "Erro desconhecido",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = headerHeight + 16.dp,
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items = uiState.turmas) { turma ->
                        TurmasCard(
                            turma = turma
                        )
                    }
                }
            }
        }
    }
}