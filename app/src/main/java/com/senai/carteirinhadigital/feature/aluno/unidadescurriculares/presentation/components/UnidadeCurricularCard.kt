package com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular

// Definição das cores personalizadas
private val Vinho = Color(0xFF8B0000)
private val PretoAcinzentado = Color(0xFF2B2B2B)

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Fundo Branco
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Text(
                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge,
                color = Vinho,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Professor: ${unidadeCurricular.professor}",
                style = MaterialTheme.typography.bodyMedium,
                color = PretoAcinzentado
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "N1: ${unidadeCurricular.nota1}",
                    color = PretoAcinzentado,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "N2: ${unidadeCurricular.nota2}",
                    color = PretoAcinzentado,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Média: ${unidadeCurricular.media}",
                    color = Vinho, // Destaque em Vinho para a média
                    fontWeight = FontWeight.Bold
                )
            }


            Text(
                text = "Faltas: ${unidadeCurricular.faltas}",
                style = MaterialTheme.typography.bodyMedium,
                color = PretoAcinzentado
            )
        }
    }
}