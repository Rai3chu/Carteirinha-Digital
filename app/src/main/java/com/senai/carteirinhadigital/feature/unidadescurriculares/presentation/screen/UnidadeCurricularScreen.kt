package com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinhadigital.feature.unidadescurriculares.data.dataSource
import com.senai.carteirinhadigital.feature.unidadescurriculares.domain.model.UnidadeCurricular
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.components.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier
){
    val unidadesCurriculares = dataSource()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                  horizontal = 16.dp,
                  vertical = 12.dp
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(unidadesCurriculares) { unidadeCurricular ->
            UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
        }
    }
}

