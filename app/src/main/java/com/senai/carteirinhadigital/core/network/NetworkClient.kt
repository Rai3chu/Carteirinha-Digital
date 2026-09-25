package com.senaisp.carteirinhadigital.core.network

import android.R.attr.level
import com.senaisp.carteirinhadigital.core.auth.AuthTokenStore
import com.senaisp.carteirinhadigital.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

class NetworkClient(
    baseUrl: String,
    authTokenStore: AuthTokenStore? = null
) {

    private val json =
        Json {
            ignoreUnknownKeys = true
        }

    private val loggingInterceptor =
        HttpLoggingInterceptor()
            .apply {
                redactHeader("Authorization")
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            }

    private val okHttpClient =
        OkHttpClient
            .Builder()
            .apply {

                if (authTokenStore != null) {
                    addInterceptor(
                        AuthInterceptor(
                            tokenStore = authTokenStore
                        )
                    )
                }

                addInterceptor(
                    loggingInterceptor
                )
            }
            .build()

    private val retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .build()

    fun <T : Any> create(
        serviceClass: Class<T>
    ): T {
        return retrofit.create(
            serviceClass
        )
    }
}
