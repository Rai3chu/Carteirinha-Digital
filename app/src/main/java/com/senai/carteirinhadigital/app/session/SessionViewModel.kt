package com.senai.carteirinhadigital.app.session

import com.senai.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionViewModel{
    private val _usuarioLogado = MutableStateFlow<UsuarioLogado?>(null)
    val usuarioLogado: StateFlow<UsuarioLogado?> = _usuarioLogado.asStateFlow()

    fun setusuarioLogado(usuario: UsuarioLogado){
        _usuarioLogado.value = usuario
    }
    fun limparSession(){
        _usuarioLogado.value = null
    }
}

