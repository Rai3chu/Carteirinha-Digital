package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation

import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)