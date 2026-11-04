package com.senai.carteirinhadigital.app.di

import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senai.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
// Importação correta do repositório do professor
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val turmaRepository: TurmaRepository

    // Repositório do Aluno
    val alunoUnidadeCurricularRepository: com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

    // Repositório do Professor
    val professorUnidadeCurricularRepository: com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository
}