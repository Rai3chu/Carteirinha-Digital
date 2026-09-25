package com.senai.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rafaelcosta.myapplication.QrCode
import com.senai.carteirinhadigital.feature.carteirinha.presentation.components.PerfilAluno
import com.senaisp.carteirinhadigital.R

@Composable
fun CarteirinhaScreen(modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = "Fundo",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxSize()

        ) {

            PerfilAluno(
                nome = "Raí Felipe",
                curso = "Desenvolvimento de Sistemas"
            )
            QrCode(
                conteudo = "90000000001755125820",
                modifier = Modifier
                    .padding(top = 50.dp)
                    .size(250.dp)
                    .border(2.dp, Color.Black)
            )

            Image(
                painter = painterResource(id = R.drawable.senai),
                contentDescription = "Fundo",
                modifier = Modifier
                    .width(200.dp)
            )

        }

    }
}