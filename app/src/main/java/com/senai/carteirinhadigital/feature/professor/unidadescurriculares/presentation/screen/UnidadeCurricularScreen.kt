package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.screen

import androidx.compose.foundation.Image // Importe a Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale // Importe o ContentScale
import androidx.compose.ui.res.painterResource // Importe o painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.UnidadeCurricularViewModel
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.component.UnidadeCurricularCard
// Substitua por com.senaisp.carteirinhadigital.R ou o pacote base do seu app onde o R está
// import com.senai.carteirinhadigital.R

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val errorMessage = uiState.errorMessage

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }


    Box(modifier = modifier.fillMaxSize()) {


        Image(
            // TODO: Troque R.drawable.sua_imagem_de_fundo pelo nome da sua imagem na pasta res/drawable
            painter = painterResource(id = R.drawable.blackbg),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Preenche a tela inteira
            modifier = Modifier.fillMaxSize()
        )


        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
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
                        color = MaterialTheme.colorScheme.error
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            viewModel.carregar()
                        }
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
                    Text("Nenhuma unidade curricular encontrada.")
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = uiState.unidades,
                        key = { it.id }
                    ) { unidadeCurricular ->
                        UnidadeCurricularCard(
                            unidadeCurricular = unidadeCurricular
                        )
                    }
                }
            }
        }
    }
}