package com.senai.carteirinhadigital.app.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.app.session.SessionViewModel
import kotlin.jvm.java

class SessionViewModelFactory(
    private val sessionTokenStore : SessionTokenStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SessionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SessionViewModel(sessionTokenStore = sessionTokenStore) as T
        }
        throw kotlin.IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}