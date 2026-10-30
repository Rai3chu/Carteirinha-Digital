package com.senai.carteirinhadigital.app.di

import android.content.Context
import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carteirinhadigital.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senaisp.carteirinhadigital.core.network.NetworkClient
import com.senaisp.carteirinhadigital.feature.login.data.remote.service.AuthApi
import com.senaisp.carteirinhadigital.feature.login.data.repository.FakeAuthRepository
import com.senai.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

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

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            serviceClass = UnidadeCurricularApi::class.java
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

    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}