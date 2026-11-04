package com.senai.carteirinhadigital.feature.turmas.domain.repository

import com.senai.carteirinhadigital.feature.turmas.domain.model.Turma

interface TurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}
