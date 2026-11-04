package com.senai.carteirinhadigital.app.di

import android.content.Context
import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senai.carteirinhadigital.feature.turmas.data.remote.TurmaApi
import com.senai.carteirinhadigital.feature.turmas.data.repository.ApiTurmaRepositoryImpl
import com.senai.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import com.senaisp.carteirinhadigital.core.network.NetworkClient
import com.senaisp.carteirinhadigital.feature.login.data.remote.service.AuthApi
import com.senaisp.carteirinhadigital.feature.login.data.repository.FakeAuthRepository

// Imports do Aluno
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl as AlunoRepositoryImpl
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi as AlunoUnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository as AlunoUnidadeCurricularRepository

// Imports do Professor
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl as ProfessorRepositoryImpl
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.remote.service.UnidadeCurricularApi as ProfessorUnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository as ProfessorUnidadeCurricularRepository

class DefaultAppContainer(
    private val context: Context
) : AppContainer {

    override val sessionTokenStore: SessionTokenStore by lazy {
        SessionTokenStore()
    }

    private val networkClient: NetworkClient by lazy {
        NetworkClient(
            baseUrl = BASE_URL,
            sessionTokenStore = sessionTokenStore
        )
    }

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(
            serviceClass = AuthApi::class.java
        )
    }

    private val alunoUnidadeCurricularApi: AlunoUnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            serviceClass = AlunoUnidadeCurricularApi::class.java
        )
    }

    private val professorUnidadeCurricularApi: ProfessorUnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            serviceClass = ProfessorUnidadeCurricularApi::class.java
        )
    }

    private val turmaApi: TurmaApi by lazy {
        networkClient.createAuthenticated(
            serviceClass = TurmaApi::class.java
        )
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(
                api = authApi
            )
        }
    }

    override val alunoUnidadeCurricularRepository: AlunoUnidadeCurricularRepository by lazy {
        AlunoRepositoryImpl(
            api = alunoUnidadeCurricularApi
        )
    }

    override val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository by lazy {
        ProfessorRepositoryImpl(
            api = professorUnidadeCurricularApi
        )
    }

    override val turmaRepository: TurmaRepository by lazy {
        ApiTurmaRepositoryImpl(
            api = turmaApi
        )
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}