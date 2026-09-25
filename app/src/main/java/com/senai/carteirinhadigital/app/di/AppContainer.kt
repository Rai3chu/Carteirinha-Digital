package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.AuthTokenStore
import com.senaisp.carteirinhadigital.feature.login.data.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}