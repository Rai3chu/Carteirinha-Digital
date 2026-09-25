package com.senaisp.carteirinhadigital.core.network

import com.senaisp.carteirinhadigital.core.auth.AuthTokenStore
import okhttp3.Response
import okhttp3.Interceptor

class AuthInterceptor(
    private val tokenStore: AuthTokenStore
) : Interceptor {

    override fun intercept(
        chain: Interceptor.Chain
    ): Response {

        val originalRequest = chain.request()

        val token = tokenStore.getToken()

        if (token.isNullOrBlank()) {
            return chain.proceed(originalRequest)
        }

        val authenticatedRequest =
            originalRequest
                .newBuilder()
                .header(
                    "Authorization",
                    "Bearer $token"
                )
                .build()

        return chain.proceed(
            authenticatedRequest
        )
    }
}