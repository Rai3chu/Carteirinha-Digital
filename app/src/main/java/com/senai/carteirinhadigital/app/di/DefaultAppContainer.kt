package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.AuthTokenStore
import com.senaisp.carteirinhadigital.core.auth.InMemoryAuthTokenStore
import com.senaisp.carteirinhadigital.core.network.NetworkClient
import com.senaisp.carteirinhadigital.feature.login.data.remote.service.AuthApi
import com.senaisp.carteirinhadigital.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senaisp.carteirinhadigital.feature.login.data.repository.FakeLoginRepositoryImpl
import com.senaisp.carteirinhadigital.feature.login.data.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.BuildConfig
import kotlin.getValue

class DefaultAppContainer : AppContainer {

    override val authTokenStore: AuthTokenStore = InMemoryAuthTokenStore()
    private val publicNetworkClient = NetworkClient(baseUrl = BuildConfig.API_BASE_URL)

    private val authenticatedNetworkClient = NetworkClient(
        baseUrl = BuildConfig.API_BASE_URL,
        authTokenStore = authTokenStore
    )

    private val authApi: AuthApi by lazy {

        publicNetworkClient.create(AuthApi::class.java)
    }


    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {

        authenticatedNetworkClient.create(UnidadeCurricularApi::class.java)
    }


    override val loginRepository: LoginRepository by lazy {

        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeLoginRepositoryImpl()

        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }


    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }


    companion object {
        private const val USE_FAKE_LOGIN_REPOSITORY =false
    }
}
