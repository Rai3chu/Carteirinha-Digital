package com.senai.carteirinhadigital.feature.aluno.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinhadigital.core.desingsystem.component.NavigationButton
import com.senai.carteirinhadigital.core.desingsystem.theme.Montserrat
import com.senai.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senaisp.carteirinhadigital.R

@Composable
fun HomeScreen(
    usuarioLogado: UsuarioLogado,
    onCarteirinhaClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    onSairClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Imagem de Fundo mantida do design original
        Image(
            painter = painterResource(id = R.drawable.redbg),
            contentDescription = "Fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Conteúdo Centralizado usando a nova estrutura lógica
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título dinâmico mantendo o design (cor e fonte)
            Text(
                text = "Olá, ${usuarioLogado.nome}",
                color = Color.White,
                fontFamily = Montserrat,
                fontSize = 32.sp, // Ajustado ligeiramente para caber um nome dinâmico
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Novo Card com os dados do usuário
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    // Leve transparência no Card para integrar com o fundo vermelho
                    containerColor = MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.95f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = usuarioLogado.curso,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = "Turma: ${usuarioLogado.turma}")

                    Text(text = "Matrícula: ${usuarioLogado.matricula}")
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Botões de navegação organizados
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                NavigationButton(
                    text = "Carteirinha",
                    onClick = onCarteirinhaClick,
                    modifier = Modifier.fillMaxWidth()
                )

                NavigationButton(
                    text = "Unidades Curriculares",
                    onClick = onUnidadesCurricularesClick,
                    modifier = Modifier.fillMaxWidth()
                )

                NavigationButton(
                    text = "Sair",
                    onClick = onSairClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}