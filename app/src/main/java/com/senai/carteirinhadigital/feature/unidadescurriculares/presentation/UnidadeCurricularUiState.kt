package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation

import com.senai.carteirinhadigital.feature.unidadescurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}