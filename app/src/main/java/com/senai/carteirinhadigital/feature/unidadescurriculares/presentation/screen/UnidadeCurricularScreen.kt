package com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.senai.carteirinhadigital.feature.unidadescurriculares.data.dataSource
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.components.UnidadeCurricularCard
import com.senaisp.carteirinhadigital.R

// Definição das cores personalizadas
val Vinho = Color(0xFF8B0000)
val PretoAcinzentado = Color(0xFF2B2B2B)
val Branco = Color.White

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    val unidadesCurriculares = dataSource()
    val headerHeight = 90.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = "Fundo da Tela",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


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
            items(unidadesCurriculares) { unidadeCurricular ->
                UnidadeCurricularCard(
                    unidadeCurricular = unidadeCurricular,

                )
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            // Botão Fixo no Canto Superior Esquerdo
            Button(
                onClick = {
                    navController.popBackStack()
                },
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