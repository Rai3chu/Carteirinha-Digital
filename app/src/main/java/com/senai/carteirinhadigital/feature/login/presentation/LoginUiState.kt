package com.senai.carteirinhadigital.feature.login.presentation

import com.senai.carteirinhadigital.feature.login.domain.model.UsuarioLogado

data class LoginUiState(
    val usuario: String = "",
    val senha : String = "",
    val erroMessage: String? = null,
    val isLoading: Boolean = false,
    val usuarioLogado: UsuarioLogado? = null
) {
    val loginRealizado: Boolean
        get() = usuarioLogado != null
}
