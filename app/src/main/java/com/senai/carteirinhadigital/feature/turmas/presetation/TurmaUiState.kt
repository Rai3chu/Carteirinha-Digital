package com.senai.carteirinhadigital.feature.turmas.presetation

import com.senai.carteirinhadigital.feature.turmas.domain.model.Turma


data class TurmaUiState(
    val isLoading: Boolean = false,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)
