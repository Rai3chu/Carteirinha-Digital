package com.senai.carteirinhadigital.feature.unidCurrProf.presetation.components

import com.senai.carteirinhadigital.feature.unidCurrProf.domain.model.UcProf

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


// Definição das cores personalizadas
private val Vinho = Color(0xFF8B0000)
private val PretoAcinzentado = Color(0xFF2B2B2B)

@Composable
fun UcProfCard(
    modifier: Modifier = Modifier,
    ucProf: UcProf
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
                text = ucProf.nome,
                style = MaterialTheme.typography.titleLarge,
                color = Vinho,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Professor: ${ucProf.professor}",
                style = MaterialTheme.typography.bodyMedium,
                color = PretoAcinzentado
            )


                Text(
                    text = " ${ucProf.materia1}",
                    color = PretoAcinzentado,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = " ${ucProf.materia2}",
                    color = PretoAcinzentado,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = " ${ucProf.materia3}",
                    color = Vinho,
                    fontWeight = FontWeight.Bold
                )

        }
    }
}