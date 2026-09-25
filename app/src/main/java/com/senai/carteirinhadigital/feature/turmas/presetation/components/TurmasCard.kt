package com.senai.carteirinhadigital.feature.turmas.presetation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.senai.carteirinhadigital.app.navigation.Routes
import com.senai.carteirinhadigital.feature.turmas.domain.model.Turmas

private val Vinho = Color(0xFF8B0000)
private val TextoPreto = Color(0xFF1A1A1A)
private val FundoCard = Color(0xFFEEEEEE)

@Composable
fun TurmasCard(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    turmas: Turmas
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = FundoCard
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = turmas.nome,
                style = MaterialTheme.typography.titleLarge,
                color = TextoPreto,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                text = "Alunos: ${turmas.alunos}",
                style = MaterialTheme.typography.bodyMedium,
                color = TextoPreto,
                fontSize = 16.sp
            )

            Button(
                onClick = {
                    navController.navigate(Routes.UcProf.route)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Vinho,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "unidades curriculares",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}