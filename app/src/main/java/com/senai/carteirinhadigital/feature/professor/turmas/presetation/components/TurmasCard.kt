package com.senai.carteirinhadigital.feature.turmas.presetation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.feature.turmas.domain.model.Turma


@Composable
fun TurmasCard(
    modifier: Modifier = Modifier,
    turma: Turma
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = turma.codigo,
                style = MaterialTheme.typography.titleLarge
            )
            if (turma.curso.isNotEmpty()) {
                Text(
                    text = "Curso: ${turma.curso}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (turma.semestre.isNotEmpty()) {
                    Text(
                        text = "Semestre: ${turma.semestre}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = "Alunos: ${turma.quantidadeAlunos}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            if (turma.diasSemana.isNotEmpty()) {
                Text(
                    text = "${turma.diasSemana.joinToString(", ")} (${turma.horarioInicio} - ${turma.horarioFim})",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}